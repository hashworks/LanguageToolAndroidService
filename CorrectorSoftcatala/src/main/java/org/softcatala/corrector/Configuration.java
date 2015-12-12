/*
 * Copyright (C) 2015 Jordi Mas i Hernàndez <jmas@softcatala.org>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package org.softcatala.corrector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Configuration {

    private static volatile Configuration instance = null;
    private static String PREF_DIALECT = "corrector.softcatala.dialect";
    private static int HttpConnections = 0;
    public static SpellCheckerSettingsActivity SettingsActivity;

    public static synchronized Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }

        return instance;
    }

    public Boolean getDialect()
    {
        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(SettingsActivity);
        Boolean dialect = spref.getBoolean(PREF_DIALECT, false);
        return dialect;
    }

    public void setDialect(Boolean dialect)
    {
        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(SettingsActivity);
        spref.edit().putBoolean(PREF_DIALECT, dialect).commit();
    }

    public int getHttpConnections()
    {
        return HttpConnections;
    }

    public void incConnections()
    {
        HttpConnections++;
    }
}
