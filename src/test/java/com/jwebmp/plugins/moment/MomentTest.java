/*
 * Copyright (C) 2016 GedMarc
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

import com.jwebmp.core.Page;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author GedMarc
 */
public class MomentTest

{

	public MomentTest()
	{
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testGetFeature()
	{
		Page<?> p = new Page();
		p.getBody()
		 .add(new Moment(new Date()));
		p.getOptions()
		 .setDynamicRender(false);
		p.renderJavascript();
		System.out.println(p.toString(true));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testJavascript()
	{
		Page<?> p = new Page();
		p.getBody()
		 .add(new Moment(new Date()));
		p.getOptions()
		 .setDynamicRender(false);
		System.out.println(p.renderJavascript());
	}

	@Test
	public void testGetAssignedDate()
	{
	}

	@Test
	public void testSetAssignedDate()
	{
	}

	@Test
	public void testGetVariableName()
	{
	}

	@Test
	public void testSetVariableName()
	{
	}

	@Test
	public void testGetAppliedFilters()
	{
	}

	@Test
	public void testSetAppliedFilters()
	{
	}

	@Test
	public void testPreConfigure()
	{
	}

	@Test
	public void testAddParseFilter()
	{
	}

	@Test
	public void testAddFromUnixFilter()
	{
	}

	@Test
	public void testAddUtc()
	{
	}

	@Test
	public void testAddUtcOffsetFilter()
	{
	}

	@Test
	public void testAddLocalFilter()
	{
	}

	@Test
	public void testAddTimezoneFilter()
	{
	}

	@Test
	public void testAddDateFormatFilter()
	{
	}

	@Test
	public void testAddCalendarFilter()
	{
	}

	@Test
	public void testAddDifferenceFilter()
	{
	}

	@Test
	public void testAddDurationFilter()
	{
	}

	@Test
	public void testAddSubtractionFilter()
	{
	}

	@Test
	public void testAddAdditionFilter()
	{
	}

}
