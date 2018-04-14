/*
 * Copyright (C) 2017 Marc Magon
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

import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.plugins.PluginInformation;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;

/**
 * @author GedMarc
 * @since 22 Feb 2017
 */
@PluginInformation(pluginName = "Moment.js",
		pluginUniqueName = "moment-datetime",
		pluginDescription = "Moment.js provides a wrapper for the native JavaScript date object. In doing this, Moment.js extends the functionality and also accounts for several deficiencies in the object.\n" + "<br/>" + "Parsing is notably unpredictable with native date. For instance, suppose I am using a computer in the United States, but I have a date in DD/MM/YYYY format.",
		pluginVersion = "2.17.1",
		pluginDependancyUniqueIDs = "jquery,angular",
		pluginCategories = "bootstrap,web ui,ui,framework,date picker,date time, moment",
		pluginSubtitle = "Parse, validate, manipulate, and display dates in JavaScript.",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-MomentPlugin",
		pluginSourceUrl = "https://momentjs.com/",
		pluginOriginalHomepage = "https://momentjs.com",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-MomentPlugin/wiki",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/MomentPlugin.jar/download",
		pluginIconUrl = "bower_components/moment/moment_icon.png",
		pluginIconImageUrl = "bower_components/moment/moment_logo.png",
		pluginLastUpdatedDate = "2017/03/04")
public class MomentPageConfigurator
		extends PageConfigurator
{

	private static final long serialVersionUID = 1L;

	public MomentPageConfigurator()
	{
		//Nothing Needed
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			page.getAngular()
			    .getAngularModules()
			    .add(new MomentAngularModule());
			page.getBody()
			    .getJavascriptReferences()
			    .add(MomentReferencePool.MomentReference.getJavaScriptReference());
			page.getBody()
			    .getJavascriptReferences()
			    .add(MomentReferencePool.MomentAngularReference.getJavaScriptReference());

			JQueryPageConfigurator.setRequired(true);
			AngularPageConfigurator.setRequired(true);
		}
		return page;
	}
}
