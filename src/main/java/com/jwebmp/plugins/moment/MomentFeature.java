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

import com.jwebmp.core.Component;
import com.jwebmp.core.Feature;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/01/16
 */
class MomentFeature
		extends Feature<MomentFeature, MomentOptions, MomentFeature>
{

	private static final long serialVersionUID = 1L;
	private MomentOptions options;

	/**
	 * Constructs a feature for
	 * <p>
	 *
	 * @param forComponent
	 */
	public MomentFeature(Component forComponent)
	{
		super("MomentJS");
		setComponent(forComponent);

	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * No Options
	 * <p>
	 *
	 * @return
	 */
	@Override
	public MomentOptions getOptions()
	{
		if (options == null)
		{
			options = new MomentOptions();
		}
		return options;
	}

	@Override
	public void assignFunctionsToComponent()
	{

		//Nothing Needed
	}
}
