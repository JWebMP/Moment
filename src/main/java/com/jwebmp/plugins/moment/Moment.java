/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.moment;

import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.utilities.StaticStrings;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.guicedee.guicedinjection.json.StaticStrings.DEFAULT_DATE_TIME_PATTERN;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * The Moment.js implementation
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * @since 29 Aug 2015
 */
@ComponentInformation(name = "Moment.js",
		description = "Parse, validate, manipulate, and display dates in JavaScript.",
		url = "https://github.com/urish/angular-moment")
public class Moment<J extends Moment<J>>
		extends Div<MomentChildren, MomentAttributes, MomentFeatures, MomentEvents, J>
		implements GlobalChildren
{


	/**
	 * The default date formatter which is parsed
	 */
	private final SimpleDateFormat DateFormatter;

	private final NumberFormat numberFormatter = NumberFormat.getInstance();
	private MomentFeature feature;
	/**
	 * The date that this moment is using
	 */
	private Date assignedDate;
	/**
	 * The variable name if this moment is bound
	 */
	private String variableName;

	private Map<MomentFilters, String> appliedFilters;

	/**
	 * Constructs an empty moment component
	 */
	@SuppressWarnings("")
	public Moment()
	{
		DateFormatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		numberFormatter.setGroupingUsed(false);
		numberFormatter.setMaximumFractionDigits(2);
		numberFormatter.setMinimumIntegerDigits(2);
		DateFormatter.applyPattern(DEFAULT_DATE_TIME_PATTERN);
		setAssignedDate(new Date());
	}

	/**
	 * Constructs a new moment with the given date and tag type
	 *
	 * @param assignedDate
	 * 		The date to use
	 * @param myComponent
	 * 		THe component tag to use
	 */
	@SuppressWarnings("")
	public Moment(Date assignedDate, ComponentTypes myComponent)
	{
		super(myComponent);
		DateFormatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		DateFormatter.applyPattern(DEFAULT_DATE_TIME_PATTERN);
		this.assignedDate = assignedDate;
	}

	/**
	 * Constructs a new moment with the given angular variable name
	 *
	 * @param variableName
	 * 		The angular variable name to use
	 * @param myComponent
	 * 		The component type to use
	 */
	@SuppressWarnings("")
	public Moment(String variableName, ComponentTypes myComponent)
	{
		super(myComponent);
		DateFormatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		DateFormatter.applyPattern(DEFAULT_DATE_TIME_PATTERN);
		this.variableName = variableName;
	}

	/**
	 * Constructs a new DIV with the given date
	 *
	 * @param assignedDate
	 * 		The date to use
	 */
	@SuppressWarnings("")
	public Moment(Date assignedDate)
	{
		DateFormatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		DateFormatter.applyPattern(DEFAULT_DATE_TIME_PATTERN);
		this.assignedDate = assignedDate;
	}

	/**
	 * Constructs a new DIV with the given angular variable
	 *
	 * @param variableName
	 * 		the new angular variable
	 */
	@SuppressWarnings("")
	public Moment(String variableName)
	{
		DateFormatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		DateFormatter.applyPattern(DEFAULT_DATE_TIME_PATTERN);
		this.variableName = variableName;
	}

	/**
	 * Returns no Options
	 *
	 * @return No options available for a moment
	 */
	@Override
	public MomentOptions getOptions()
	{
		return getFeature().getOptions();
	}

	/**
	 * Returns the given feature
	 *
	 * @return
	 */
	public final MomentFeature getFeature()
	{
		if (feature == null)
		{
			feature = new MomentFeature(this);
		}
		return feature;
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			addFeature(getFeature());
			addAttribute(MomentAttributes.am_time_ago, buildAttributeString());
		}
		super.preConfigure();
	}

	/**
	 * Builds the list of given filters
	 *
	 * @return
	 */
	private String buildAttributeString()
	{
		StringBuilder sb = new StringBuilder();
		if (variableName != null)
		{
			sb.append(variableName);
		}
		else if (assignedDate != null)
		{
			sb.append(STRING_SINGLE_QUOTES)
			  .append(DateFormatter.format(assignedDate))
			  .append(STRING_SINGLE_QUOTES);
			getAppliedFilters().put(MomentFilters.amParse, "YYYY-MM-DD HH:mm:ss");
		}
		if (!getAppliedFilters().isEmpty())
		{
			getAppliedFilters().forEach((key, value) ->
			                            {
				                            if (value != null)
				                            {
					                            sb.append(" | ")
					                              .append(key)
					                              .append(" : '")
					                              .append(value)
					                              .append(STRING_SINGLE_QUOTES);
				                            }
				                            else
				                            {
					                            sb.append(" | ")
					                              .append(key);
				                            }
			                            });
		}
		return sb.toString();
	}

	/**
	 * Return the HashMap of filters applied to this moment
	 *
	 * @return
	 */
	public Map<MomentFilters, String> getAppliedFilters()
	{
		if (appliedFilters == null)
		{
			appliedFilters = new EnumMap<>(MomentFilters.class);
		}
		return appliedFilters;
	}

	/**
	 * Sets this moment list of applied filters
	 *
	 * @param appliedFilters
	 */
	public void setAppliedFilters(Map<MomentFilters, String> appliedFilters)
	{
		this.appliedFilters = appliedFilters;
	}

	/**
	 * Parses a custom-formatted date into a moment object that can be used with the am-time-ago directive and the other filters. For example, the following code will accept dates
	 * that are formatted
	 * like "2015.04.25 22:00:15':
	 * <p>
	 * am-time-ago="message.time | amParse:'YYYY.MM.DD HH:mm:ss'"
	 * <p>
	 * Note: To use amParse, install angular-moment version 1.0.0-beta.3 or newer
	 *
	 * @param parseSyntax
	 */
	public void AddParseFilter(String parseSyntax)
	{
		getAppliedFilters().put(MomentFilters.amParse, parseSyntax);
	}

	/**
	 * Converts a unix-timestamp (seconds since 1/1/1970) into a moment object. Example:
	 * <p>
	 * span am-time-ago="message.unixTime | amFromUnix"
	 */
	public void AddFromUnixFilter()
	{
		getAppliedFilters().put(MomentFilters.amFromUnix, null);
	}

	/**
	 * Create / switch the current moment object into UTC mode. For example, given a date object in message.date, the following code will display the time in UTC instead of the
	 * local timezone:
	 * <p>
	 * {{message.date | amUtc | amDateFormat:'MM.DD.YYYY HH:mm:ss'}}
	 */
	public void AddUtc()
	{
		getAppliedFilters().put(MomentFilters.amUtc, null);
	}

	/**
	 * Uses the given U offset when displaying a date. For example, the following code will display the date with a UTC + 3 hours time offset:
	 * <p>
	 * {{message.date | amUtcOffset:'+0300' | amDateFormat:'MM.DD.YYYY HH:mm:ss'}}/span
	 *
	 * @param timeToChange
	 * 		the time to change, use like 3.0, or 3.30
	 */
	public void AddUtcOffsetFilter(double timeToChange)
	{
		String timeSet = "+" + numberFormatter.format(timeToChange)
		                                      .replace(STRING_DOT, STRING_EMPTY);
		getAppliedFilters().put(MomentFilters.amUtcOffset, timeSet);
	}

	/**
	 * Changes the given moment object to be in the local timezone. Usually used in conjunction with amUtc / amTimezone for timezone conversion. For example, the following will
	 * convert the given UTC
	 * date to local time:
	 * <p>
	 * {{message.date | amUtc | amLocal | amDateFormat:'MM.DD.YYYY HH:mm:ss'}}
	 */
	public void AddLocalFilter()
	{
		getAppliedFilters().put(MomentFilters.amLocal, null);
	}

	/**
	 * this guy needs to get done https://github.com/urish/angular-moment
	 */
	public void AddTimezoneFilter()
	{
		//Must Be Done
	}

	/**
	 * Format dates using moment.js format() method. Example:
	 * <p>
	 * {{message.time | amDateFormat:'dddd, MMMM Do YYYY, h:mm:ss a'}}
	 * <p>
	 * This snippet will format the given time as "Monday, October 7th 2013, 12:36:29 am".
	 *
	 * @param dateformat
	 */
	public void AddDateFormatFilter(String dateformat)
	{
		getAppliedFilters().put(MomentFilters.amDateeFormat, dateformat);
	}

	/**
	 * Format dates using moment.js calendar() method. Example:
	 * <p>
	 * span&gt;{{message.time | amCalendar:referenceTime:formats}}/span
	 * <p>
	 * This snippet will format the given time as e.g. "Today 2:30 AM" or "Last Monday 2:30 AM" etc..
	 */
	public void AddCalendarFilter()
	{
		getAppliedFilters().put(MomentFilters.amCalendar, "referenceTime:formats");
	}

	/**
	 * this guy... ;/ https://github.com/urish/angular-moment
	 */
	public void AddDifferenceFilter()
	{
		getAppliedFilters().put(MomentFilters.amDifference, "referenceTime:formats");
	}

	/**
	 * Formats a duration (such as 5 days) in a human readable format. See Moment.JS documentation for a list of supported duration formats, and humanize() documentation for
	 * explanation about the
	 * formatting algorithm.
	 * <p>
	 * Example:
	 * <p>
	 * Message age: {{message.ageInMinutes | amDurationFormat : 'minute' }}
	 * <p>
	 * Will display the age of the message (e.g. 10 minutes, 1 hour, 2 days, etc).
	 *
	 * @param duration
	 */
	public void AddDurationFilter(DurationFilters duration)
	{
		getAppliedFilters().put(MomentFilters.amDurationFormat, duration.toString());
	}

	/**
	 * Subtract values (hours, minutes, seconds ...) from a specified date.
	 *
	 * @param amount
	 * @param part
	 */
	public void AddSubtractionFilter(int amount, DurationFilters part)
	{
		getAppliedFilters().put(MomentFilters.amSubtract, Integer.toString(amount) + "' : '" + part.toString() + "");
	}

	/**
	 * Adds values (hours, minutes, seconds ...) from a specified date.
	 *
	 * @param amount
	 * @param part
	 */
	public void AddAdditionFilter(int amount, DurationFilters part)
	{
		getAppliedFilters().put(MomentFilters.amAdd, Integer.toString(amount) + "' : '" + part.toString() + "");
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		Moment<?> moment = (Moment<?>) o;

		if (!DateFormatter.equals(moment.DateFormatter))
		{
			return false;
		}
		if (!numberFormatter.equals(moment.numberFormatter))
		{
			return false;
		}
		if (!getFeature().equals(moment.getFeature()))
		{
			return false;
		}
		if (!getAssignedDate().equals(moment.getAssignedDate()))
		{
			return false;
		}
		if (getVariableName() != null ? !getVariableName().equals(moment.getVariableName()) : moment.getVariableName() != null)
		{
			return false;
		}
		return getAppliedFilters().equals(moment.getAppliedFilters());
	}

	/**
	 * Returns the assigned date
	 *
	 * @return
	 */
	public Date getAssignedDate()
	{
		return assignedDate;
	}

	/**
	 * Returns the assigned date
	 *
	 * @param assignedDate
	 */
	public void setAssignedDate(Date assignedDate)
	{
		this.assignedDate = assignedDate;
	}

	/**
	 * Returns the assigned variable name
	 *
	 * @return
	 */
	public String getVariableName()
	{
		return variableName;
	}

	/**
	 * Sets the assigned variable name
	 *
	 * @param variableName
	 */
	public void setVariableName(String variableName)
	{
		this.variableName = variableName;
	}

	/**
	 * The available descernable parts
	 */
	public enum DurationFilters
	{
		Years,
		Hours,
		Minutes,
		Days,
		Months,
		Seconds;

		@Override
		public String toString()
		{
			return name().toLowerCase();
		}
	}
}
