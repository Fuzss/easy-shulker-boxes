plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modApi(sharedLibs.puzzleslib.neoforge)
    modApi(sharedLibs.iteminteractions.neoforge)
    include(sharedLibs.iteminteractions.neoforge)
}
