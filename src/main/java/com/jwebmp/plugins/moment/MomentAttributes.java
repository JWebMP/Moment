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

import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.CHAR_DASH;
import static com.guicedee.services.jsonrepresentation.json.StaticStrings.CHAR_UNDERSCORE;

/**
 * Specifies the am time ago flag for moment accessing
 *
 * @author GedMarc
 * 2since 201/10/05
 */
public enum MomentAttributes
        implements AttributeDefinitions
{

    am_time_ago;

    MomentAttributes()
    {
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase()
                .replace(CHAR_UNDERSCORE, CHAR_DASH);
    }
}
