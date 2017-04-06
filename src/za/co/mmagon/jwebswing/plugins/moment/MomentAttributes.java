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
package za.co.mmagon.jwebswing.plugins.moment;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Specifies the am time ago flag for moment accessing
 *
 * @author GedMarc
 * 2since 201/10/05
 */
enum MomentAttributes implements AttributeDefinitions
{

    am_time_ago;

    private MomentAttributes()
    {
    }

    private MomentAttributes(boolean isKeyword)
    {
        this.isKeyword = isKeyword;
    }

    private boolean isKeyword;

    @Override
    public boolean isKeyword()
    {
        return isKeyword;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
}
