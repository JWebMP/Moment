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

import com.jwebmp.core.base.angular.modules.AngularModuleBase;
import com.jwebmp.core.base.angular.services.IAngularModule;

/**
 * Registers the moment angular module as available for the
 *
 * @author GedMarc
 * @version 1.0
 * @since Oct 4, 2016
 */
public class MomentAngularModule
		extends AngularModuleBase
		implements IAngularModule<MomentAngularModule>
{


	/**
	 * Constructs a new angular module
	 */
	public MomentAngularModule()
	{
		super("angularMoment");
	}

	@Override
	public String renderFunction()
	{
		return "";
	}

	/**
	 * If this page configurator is enabled
	 *
	 * @return if the configuration must run
	 */
	@Override
	public boolean enabled()
	{
		return MomentPageConfigurator.isEnabled();
	}
}
