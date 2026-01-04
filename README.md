# BepHax Meteor Addon build

[![GitHub Release](https://img.shields.io/github/v/release/dekrom/BepHaxAddon?include_prereleases&label=Latest%20Release)](https://github.com/dekrom/BepHaxAddon/releases)
[![GitHub License](https://img.shields.io/github/license/dekrom/BepHaxAddon)](https://github.com/dekrom/BepHaxAddon/blob/main/LICENSE)
[![GitHub Issues](https://img.shields.io/github/issues/dekrom/BepHaxAddon)](https://github.com/dekrom/BepHaxAddon/issues)

## What it is?

BepHax is created to simplify 2b2t.org players' lives by combining the best utility modules from various addons into one accessible Meteor Client addon, optimized for compatibility and ease of use on the 2b2t anarchy server.

## Installation

1. Download the latest JAR from the [Releases](https://github.com/dekrom/BepHaxAddon/releases) page.
2. Place the JAR file in your Minecraft mods folder (typically `~/.minecraft/mods` on Fabric Loader).
3. Launch Minecraft with Fabric and Meteor Client installed.
4. Activate modules via the Meteor Client GUI (default key: Right Shift).

**Requirements:**
- Minecraft 1.21.4
- Fabric Loader 0.16.10 or compatible
- Meteor Client (latest snapshot for 1.21.4)
- Baritone API
- XaeroMinimap
- XaeroWorldMap
- XaeroPlus

## Features

BepHax organizes modules into custom categories: **Bephax** (general utilities), **Stash Hunt** (exploration and stash finding), **Bobers** (highway borers), and **HIG Tools** (highway and infrastructure tools).

### Original/Improved Modules (by BepHax Maintainer)
These modules were created or enhanced specifically for this addon:
- **AutoSmithing**: Automates smithing table upgrades.
- **YawLock**: Locks player yaw for precise movement.
- **UnfocusedFpsLimiter**: Limits FPS when the game window is unfocused.

### Modules from JEFF Stash Hunting (Credit: [miles352](https://github.com/miles352/meteor-stashhunting-addon))
- **ElytraFlyPlusPlus**: Enhanced elytra flying controls.
- **AFKVanillaFly**: AFK flying without mods.
- **NoJumpDelay**: Removes jump cooldown.
- **AutoEXPPlus**: Automates experience mending.
- **AutoLogPlus**: Auto-logout on low health or threats.
- **AutoPortal**: Automatic portal creation.
- **ChestIndex**: Indexes and searches chest contents.
- **GotoPosition**: Teleports to specified coordinates (use responsibly).
- **HighlightOldLava**: Highlights ancient lava sources.
- **Pitch40Util**: Utility for 40-degree pitch mining.
- **GrimAirPlace**: Grim-compatible air placement.
- **TrailFollower**: Follows player trails.
- **VanityESP**: Custom entity ESP for vanity items.
- **BetterStashFinder**: Improved stash location finder.
- **OldChunkNotifier**: Notifies of old chunks.
- **SearchArea**: Defines search areas for resources.

### Modules from HIGTools (Credit: [RedCarlos26](https://github.com/RedCarlos26/HIGTools))
- **AfkLogout**: Logs out after AFK time.
- **AutoCenter**: Centers player on blocks.
- **AutoWalkHIG**: Automatic walking for highways.
- **AxisViewer**: Displays axis lines.
- **HighwayBuilderHIG**: Builds highways automatically.
- **HighwayTools**: Tools for highway maintenance.
- **HotbarManager**: Manages hotbar slots.
- **LiquidFillerHIG**: Fills liquids on highways.
- **OffhandManager**: Manages offhand items.
- **ScaffoldHIG**: Scaffolding for highway building.
- **Coordinates Command**: Displays or shares coordinates.

### Borers
- **AxisBorer**: Bores along axes.
- **NegNegBorer**: Negative-negative direction borer.
- **NegPosBorer**: Negative-positive direction borer.
- **PosNegBorer**: Positive-negative direction borer.
- **PosPosBorer**: Positive-positive direction borer.

### Modules from TrouserStreak (Credit: [etianl](https://github.com/etianl/Trouser-Streak))
- **BetterScaffold**: Improved scaffolding.
- **SuperInstaMine**: Super-fast instant mining.
- **BetterAutoSign**: Enhanced auto-sign placement.

### Modules from IKEA (Credit: [Nooniboi](https://github.com/Nooniboi/Public-Ikea))
- **AntiInteract**: Prevents unwanted interactions.
- **AutoItemMove**: Automatically moves items.
- **AntiDrop**: Prevents item drops.
- **DubCounter**: Counts double chests.

### Modules from Meteor Rejects (Credit: [AntiCope](https://github.com/AntiCope))
- **AutoCraft**: Automates crafting.
- **VehicleOneHit**: One-hit vehicle destruction.

### Commands and Modules from Stardust (Credit: [0xTas](https://github.com/0xTas/stardust))
- **Commands**:
  - FirstSeen2b2t: Checks first seen date on 2b2t.
  - LastSeen2b2t: Checks last seen date on 2b2t.
  - Playtime2b2t: Checks playtime on 2b2t.
  - Stats2b2t: Displays player stats on 2b2t.
  - Panorama: Custom panorama utilities.
  - Loadout: Manages loadouts.
- **Modules**:
  - Loadouts: Saves and loads player loadouts.
  - AntiToS: Bypasses ToS restrictions.
  - ChatSigns: Signs in chat.
  - Archaeology: Archaeology utilities.
  - AutoDoors: Automatically opens doors.
  - AutoDrawDistance: Adjusts draw distance.
  - AutoDyeShulkers: Dyes shulkers automatically.
  - AxolotlTools: Axolotl-related tools.
  - BannerData: Displays banner data.
  - BookTools: Book editing tools.
  - Honker: Custom honking sounds.
  - LoreLocator: Locates lore items.
  - MusicTweaks: Music system tweaks.
  - PagePirate: Page utilities.
  - RapidFire: Fast firing.
  - RoadTrip: Travel utilities.
  - RocketJump: Rocket jumping.
  - RocketMan: Rocket enhancements.
  - SignHistorian: Sign history.
  - SignatureSign: Signs signatures.
  - StashBrander: Brands stashes.
  - WaxAura: Waxing utilities.
  - TreasureESP: ESP for treasures.
  - Updraft: Updraft flying.

### Modules from Meteorist (Credit: [Zgoly](https://github.com/Zgoly/Meteorist/))
- **DisconnectSound**: Plays sound on disconnect.

### HUD Elements
- **BlockCounterHud**: Counts blocks in inventory.

## Credits
This addon aggregates modules from the following projects—huge thanks to their creators for open-sourcing their work:
- [JEFF Stash Hunting](https://github.com/miles352/meteor-stashhunting-addon) by miles352
- [HIGTools](https://github.com/RedCarlos26/HIGTools) by RedCarlos26
- [TrouserStreak](https://github.com/etianl/Trouser-Streak) by etianl
- [IKEA](https://github.com/Nooniboi/Public-Ikea) by Nooniboi
- [Meteor Rejects](https://github.com/AntiCope) by AntiCope
- [Stardust](https://github.com/0xTas/stardust) by 0xTas
- [Meteorist](https://github.com/Zgoly/Meteorist/) by Zgoly

Uncredited modules were developed or refined by me to fit 2b2t needs.

## Contributing
BepHax is community-driven! If you'd like to suggest features, report bugs, or contribute code, open an issue or pull request. Everyone can request changes to make this addon better for the 2b2t community.

## License
Licensed under [GNU GPLv3](LICENSE). Feel free to fork and modify!
