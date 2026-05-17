plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modCompileOnly(sharedLibs.puzzleslib.common)
    modApi(sharedLibs.puzzleslib.neoforge)
    modCompileOnly(sharedLibs.iteminteractions.common)
    modApi(sharedLibs.iteminteractions.neoforge)
    include(sharedLibs.iteminteractions.neoforge)
}
