# Void Waker Set (Fabric 26.3)

This is the starter project ZIP for the `iDog-ProMax/Voidwaker-set` repository.

## Build it on GitHub

1. Extract this ZIP.
2. Upload the **contents** of the `Void-Waker-Set` folder to the root of your empty GitHub repository (not the enclosing folder).
3. Commit the files to the `main` branch.
4. Open the repository's **Actions** tab. The workflow named **Build Void Waker Set** will run.
5. When it finishes successfully, open that workflow run, scroll to **Artifacts**, and download `void-waker-set-1.0.0`.
6. Extract the artifact ZIP. The mod `.jar` will be inside `build/libs/`.

Minecraft 26.3 uses Java 25. The GitHub Actions workflow installs Java 25 for the build, so you do not need Java 25 on your own computer.

## Current implementation status

This first build registers the Dragonite Ore block, Dragonite Ingot item, four Void Waker-named armour-slot items, and five Void Waker-named tool items. It also includes a basic block loot table and the GitHub build workflow.

**Important:** the armour-slot items are currently registered as ordinary items, not wearable armour. The tools are currently registered as ordinary items, not functional tools. Regeneration II, the Dragon's Breath ability, End City chest injection/one-item-per-chest rule, Dragonite world generation, recipes, textures, and full equipment stats are not implemented in this starter build yet. Those need another implementation and test pass against the 26.3 API before this can honestly be called the finished mod.

## Version pins

The project is based on the FabricMC example-mod 26.3 setup:
- Minecraft 26.3
- Fabric Loader 0.20.1
- Fabric API 0.165.0+26.3
- Loom 1.19-SNAPSHOT
- Java 25
- Gradle 9.8.2
