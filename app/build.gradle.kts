plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.taskcompanion"
    compileSdk = 35   //

    defaultConfig {
        applicationId = "com.example.taskcompanion"
        minSdk = 24
        targetSdk = 35  //
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // ROOM
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Compose (no BOM version conflict setup)
    implementation("androidx.compose.ui:ui:1.5.10")
    implementation("androidx.compose.ui:ui-graphics:1.5.10")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.10")
    implementation("androidx.compose.material3:material3:1.2.0")

    // Core Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
}