plugins {
    id("com.android.application")
}

android {
    namespace = "com.ianalvarez.miniappperfil"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.ianalvarez.miniappperfil"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}
