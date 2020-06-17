# env-paths

> Get paths for storing things like data, config, cache, etc.

Uses the correct OS-specific paths. No dependencies.

Based on <https://github.com/sindresorhus/env-paths/>
by [Sindre Sorhus](https://github.com/sindresorhus) and [contributors](https://github.com/sindresorhus/env-paths/graphs/contributors).

## Installation

Add <https://jitpack.io> to your repositories:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Add the dependency in your `pom.xml` file:

```xml
<dependency>
    <groupId>com.github.open-fidias</groupId>
    <artifactId>env-paths</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Usage

All you need to do is create an instance of `EnvPaths` and call the methods. Example:

```java
EnvPaths paths = EnvPaths.newInstance("my-app");

// On Linux
paths.getDataPath();
//=> '/home/fidias/.local/share/my-app'

paths.getData();
//=> File('/home/fidias/.local/share/my-app')

paths.getConfigPath();
//=> '/home/fidias/.config/my-app'

paths.getConfig();
//=> File('/home/fidias/.config/my-app')
```

The complete API can be found at <https://jitpack.io/com/github/open-fidias/env-paths/latest/javadoc/>.

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :smile:

## LICENSE

Copyright (C) 2020  Átila Camurça <camurca.home@gmail.com>
Fidias Free and Open Source Team <fidiascom@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
