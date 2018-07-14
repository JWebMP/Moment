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
package com.jwebmp.base.angular.modules;

import com.jwebmp.Page;
import com.jwebmp.base.html.Body;
import com.jwebmp.plugins.moment.Moment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class AngularModuleBaseTest

{

	public AngularModuleBaseTest()
	{
	}

	@Test
	public void testModuleBase()
	{
		Page p = new Page();
		Body b = p.getBody();
		b.add(new Moment());
		AngularModuleBase comp = new JWAngularModule(p);
		System.out.println(comp.toString());
		Assertions.assertTrue(comp.toString()
		                          .contains("'angularMoment'"));

		System.out.println(p.toString(true));

	}
}
