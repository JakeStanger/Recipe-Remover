# Note

I do not, and do not plan to, maintain this mod. Feel free to do whatever you want with it - include it in your modpack, clone it and update it, modify it or whatever. Personally, I'd recommend using Minetweaker instead as it does everything this does and more, with greater mod support.

Minecraft version 1.7.10.

# About

A very small Minecraft mod which allows you to remove ALL recipes for ANY block/item from ANY mod.

## Installation

1. Install Minecraft Forge - http://files.minecraftforge.net/
2. Go to your Minecraft base directory (%appdata%\.minecraft for vanilla)
3. Go to the mods folder (if there isn't one, create one!)
4. Place the latest version of this mod in there - https://github.com/Roboguy99/Recipe-Remover/releases
5. Run the game
6. Close the game


## Usage
1. Go to your Minecraft base directory \ config
2. Open RecipeRemover.cfg
3. Place the textual ID of each block/item on a separate line (see below on how to find them)
4. Save the file
5. Open the game

## Finding IDs

I have implemented a basic command (/id <id> or /findid <id>) which allows you to enter the number ID (e.g. stone is 1, cobblestone is 4) and returns the textual ID (e.g. stone is minecraft:stone). You can also use the link below to find IDs from vanilla items/blocks:
http://minecraft-ids.grahamedgecombe.com/ 

If you are in-game and holding an item in your hand, you can use /handid or /holdingid to return the textualID.
