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

import com.jwebmp.Component;
import com.jwebmp.Feature;
import com.jwebmp.base.html.interfaces.GlobalFeatures;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/01/16
 */
class MomentFeature
		extends Feature<MomentOptions, MomentFeature>
		implements MomentFeatures, GlobalFeatures
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
		int result = super.hashCode();
		result = 31 * result + getOptions().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof MomentFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		MomentFeature that = (MomentFeature) o;

		return getOptions().equals(that.getOptions());
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
