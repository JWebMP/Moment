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

import com.jwebmp.core.*;
import com.jwebmp.core.base.angular.services.annotations.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.core.services.*;
import jakarta.validation.constraints.*;

/**
 * @author GedMarc
 * @since 22 Feb 2017
 */
@PluginInformation(pluginName = "Moment.js",
		pluginUniqueName = "moment-datetime",
		pluginDescription =
				"Moment.js provides a wrapper for the native JavaScript date object. In doing this, Moment.js extends the functionality and also accounts for several deficiencies in the object.\n" +
				"<br/>" +
				"Parsing is notably unpredictable with native date. For instance, suppose I am using a computer in the United States, but I have a date in DD/MM/YYYY format.",
		pluginVersion = "2.17.1",
		pluginDependancyUniqueIDs = "jquery,angular",
		pluginCategories = "bootstrap,web ui,ui,framework,date picker,date time, moment",
		pluginSubtitle = "Parse, validate, manipulate, and display dates in JavaScript.",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-MomentPlugin",
		pluginSourceUrl = "https://momentjs.com/",
		pluginOriginalHomepage = "https://momentjs.com",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-MomentPlugin/wiki",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.javascript/jwebmp-momentjs",
		pluginIconUrl = "bower_components/moment/moment_icon.png",
		pluginIconImageUrl = "bower_components/moment/moment_logo.png",
		pluginLastUpdatedDate = "2017/03/04",
		pluginGroupId = "com.jwebmp.plugins.javascript",
		pluginArtifactId = "jwebmp-momentjs",
		pluginModuleName = "com.jwebmp.plugins.moment",
		pluginStatus = PluginStatus.Released
)
@TsDependency(value = "moment",version = "^2.29.3")
public class MomentPageConfigurator
		implements IPageConfigurator<MomentPageConfigurator>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;

	public MomentPageConfigurator()
	{
		//Nothing Needed
	}

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return MomentPageConfigurator.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		MomentPageConfigurator.enabled = mustEnable;
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	 public Page<?> configure(Page<?> page)
	{
		return page;
	}

	@Override
	public boolean enabled()
	{
		return MomentPageConfigurator.enabled;
	}
}
