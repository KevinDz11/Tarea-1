plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // REMOVER: alias(libs.plugins.kotlin.compose) ← Esto es para Compose, tú usas Views XML
}

android {
    namespace = "com.example.tarea1"
    compileSdk = 36 // Cambiar a 34 (36 puede ser demasiado nuevo)

    defaultConfig {
        applicationId = "com.example.tarea1"
        minSdk = 24
        targetSdk = 34 // Cambiar a 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    // REMOVER: buildFeatures { compose = true } ← Esto es para Compose, tú usas Views XML

    // AGREGAR: Para ViewBinding si lo necesitas
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Dependencias principales (usando libs.)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    implementation("com.google.android.material:material:1.12.0")

    // Dependencias de lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Dependencias de fragment y navegación
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)

    // Dependencias de RecyclerView
    implementation(libs.androidx.recyclerview)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}