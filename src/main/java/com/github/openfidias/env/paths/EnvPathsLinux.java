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

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author atila
 */
class EnvPathsLinux {

    static EnvPaths newInstance(final String name) {
        String homedir = SystemUtils.getUserDirPath();
        String username = SystemUtils.getUserName();

        Path data = Paths.get(getDataHome(homedir), name);
        Path config = Paths.get(getConfigHome(homedir), name);
        Path cache = Paths.get(getCacheHome(homedir), name);
        Path log = Paths.get(getStateHome(homedir), name);
        Path temp = Paths.get(SystemUtils.getJavaIoTmpDirPath(), username, name);

        return new EnvPaths(
                name,
                data.toFile(),
                config.toFile(),
                cache.toFile(),
                log.toFile(),
                temp.toFile()
        );
    }

    private static String getDataHome(String homedir) {
        return SystemUtils.getEnvironmentVariable("XDG_DATA_HOME",
                Paths.get(homedir, ".local", "share").toString());
    }

    private static String getConfigHome(String homedir) {
        return SystemUtils.getEnvironmentVariable("XDG_CONFIG_HOME",
                Paths.get(homedir, ".config").toString());
    }

    private static String getCacheHome(String homedir) {
        return SystemUtils.getEnvironmentVariable("XDG_CACHE_HOME",
                Paths.get(homedir, ".cache").toString());
    }

    /**
     * Reference: https://wiki.debian.org/XDGBaseDirectorySpecification#state
     *
     * @return
     */
    private static String getStateHome(String homedir) {
        return SystemUtils.getEnvironmentVariable("XDG_STATE_HOME",
                Paths.get(homedir, ".local", "state").toString());
    }
}
