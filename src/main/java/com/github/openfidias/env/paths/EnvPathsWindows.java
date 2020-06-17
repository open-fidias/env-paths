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
class EnvPathsWindows {

    static EnvPaths newInstance(String name) {
        String homedir = SystemUtils.getUserDirPath();
        String appData = getAppData(homedir);
        String localAppData = getLocalAppData(homedir);

        // Data/config/cache/log are invented by me as Windows isn't opinionated about this
        Path data = Paths.get(localAppData, name, "Data");
        Path config = Paths.get(appData, name, "Config");
        Path cache = Paths.get(localAppData, name, "Cache");
        Path log = Paths.get(localAppData, name, "Log");
        Path temp = Paths.get(SystemUtils.getJavaIoTmpDirPath(), name);

        return new EnvPaths(
                name,
                data.toFile(),
                config.toFile(),
                cache.toFile(),
                log.toFile(),
                temp.toFile()
        );
    }

    static String getAppData(String homedir) {
        return SystemUtils.getEnvironmentVariable("APPDATA",
                Paths.get(homedir, "AppData", "Roaming").toString());
    }

    static String getLocalAppData(String homedir) {
        return SystemUtils.getEnvironmentVariable("LOCALAPPDATA",
                Paths.get(homedir, "AppData", "Local").toString());
    }
}
