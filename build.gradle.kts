plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    dependencies {
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.ui)
        implementation(compose.components.resources)
        implementation(compose.components.uiToolingPreview)

        val voyagerVersion = "1.0.0"
        implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
    }
}