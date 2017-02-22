/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package za.co.mmagon.jwebswing.plugins.moment;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 *
 * @author GedMarc
 * @since 22 Feb 2017
 *
 */
@PluginInformation(pluginName = "Moment (Date Time Handler)", pluginUniqueName = "moment-datetime", pluginDescription = "Parse, validate, manipulate, and display dates in JavaScript.", pluginVersion = "2.17.1",
        pluginDependancyUniqueIDs = "jquery,angular", pluginCategories = "bootstrap,web ui,ui,framework,date picker,date time, moment", pluginSubtitle = "",
        pluginGitUrl = "https://github.com/GedMarc/JWebSwing-MomentPlugin", pluginSourceUrl = "https://momentjs.com/",
        pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-MomentPlugin/wiki")
public class MomentPageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;

    public MomentPageConfigurator()
    {

    }

    @Override
    public Page configure(Page page)
    {
        if (!page.isConfigured())
        {

            page.getBody().getAngularModules().add(new MomentAngularModule(page.getBody()));
            page.getBody().getJavascriptReferences().add(MomentReferencePool.MomentReference.getJavaScriptReference());
            page.getBody().getJavascriptReferences().add(MomentReferencePool.MomentAngularReference.getJavaScriptReference());
        }
        return page;
    }
}
