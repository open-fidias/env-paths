/**
 * env-paths: Get paths for storing things like data, config, cache, etc.
 * Based on the <https://github.com/sindresorhus/env-paths> by Sindre Sorhus and contributors
 *
 * Copyright (C) 2020 Átila Camurça <camurca.home@gmail.com>
 * Fidias Free and Open Source Team <fidiascom@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.openfidias.env.paths;

import java.io.File;

/**
 *
 * @author atila
 */
public class EnvPaths {

    private final String name;
    private final File data;
    private final File config;
    private final File cache;
    private final File log;
    private final File temp;

    EnvPaths(String name, File data, File config, File cache, File log, File temp) {
        this.name = name;
        this.data = data;
        this.config = config;
        this.cache = cache;
        this.log = log;
        this.temp = temp;
    }

    public static EnvPaths newInstance(final String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("Parameter name required.");
        }

        if (SystemUtils.IS_OS_MAC) {
            return EnvPathsMacos.newInstance(name);
        }

        if (SystemUtils.IS_OS_WINDOWS) {
            return EnvPathsWindows.newInstance(name);
        }
        return EnvPathsLinux.newInstance(name);
    }

    public String getName() {
        return name;
    }

    public File getData() {
        return data;
    }

    public String getDataPath() {
        return data.getAbsolutePath();
    }

    public File getConfig() {
        return config;
    }

    public String getConfigPath() {
        return config.getAbsolutePath();
    }

    public File getCache() {
        return cache;
    }

    public String getCachePath() {
        return cache.getAbsolutePath();
    }

    public File getLog() {
        return log;
    }

    public String getLogPath() {
        return log.getAbsolutePath();
    }

    public File getTemp() {
        return temp;
    }

    public String getTempPath() {
        return temp.getAbsolutePath();
    }
}
