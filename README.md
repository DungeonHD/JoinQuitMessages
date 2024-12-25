# JoinQuitMessages Plugin

JoinQuitMessages is a simple Spigot plugin designed to customize the messages displayed when a player joins or quits the server.
It allows server administrators to configure the messages easily through the `config.yml` file.
The plugin supports Minecraft versions 1.20 and 1.21, and includes a reload command to update the configuration without restarting the server.

## Features

- Customizable join and quit messages
- Reload the configuration using `/jqm reload`
- Supports Minecraft 1.20 and 1.21
- Configuration via `config.yml`
- Permission system for reloading the plugin configuration

## Installation

1. Download the latest version of the plugin from the Releases section.
2. Place the `JoinQuitMessages.jar` file into the `plugins` folder of your Spigot or Paper server.
3. Restart your server, and the plugin will generate the necessary configuration files.

## Configuration

After installing the plugin, a `config.yml` file will be generated in the plugin's folder. You can customize the join and quit messages there. For example:

```yaml
JoinMessage: '&7(&a+&7) %player% joined'
QuitMessage: '&7(&c-&7) %player% left'
```


## License

MIT License

Copyright (c) [2024] [DungeonFinder]

Permission is hereby granted, free of charge, to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is provided to do so, subject to the following conditions:

- The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
- The Software is provided "as is", without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages, or other liability, whether in an action of contract, tort, or otherwise, arising from, out of, or in connection with the software or the use or other dealings in the Software.
