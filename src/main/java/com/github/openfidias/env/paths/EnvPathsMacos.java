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
class EnvPathsMacos {

    static EnvPaths newInstance(String name) {
        String homedir = SystemUtils.getUserHomePath();
        String library = Paths.get(homedir, "Library").toString();

        Path data = Paths.get(library, "Application Support", name);
        Path config = Paths.get(library, "Preferences", name);
        Path cache = Paths.get(library, "Caches", name);
        Path log = Paths.get(library, "Logs", name);
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
}
