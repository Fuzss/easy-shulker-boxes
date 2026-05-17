plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
    modApi(sharedLibs.iteminteractions.fabric)
    include(sharedLibs.iteminteractions.fabric)
}
