plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.mx.eventbuspatt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mx.eventbuspatt"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true;
    }
    buildFeatures {
        compose = true // Habilitar Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0" // Usa la versión compatible de Compose
    }
}

dependencies {
    // Dependencias principales de Compose
    implementation("androidx.compose.ui:ui:1.5.3")  // Versión coherente
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.3")  // Versión coherente
    implementation("androidx.activity:activity-compose:1.7.0")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // ViewModel con extensiones de Kotlin
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    // ViewModel para Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // Guardar estados en ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.2")

    // Extensiones de ciclo de vida
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Material Design for Jetpack Compose
    implementation("androidx.compose.material:material:1.5.3")  // Versión coherente
    // Material Icons
    implementation("androidx.compose.material:material-icons-core:1.5.3")
    implementation("androidx.compose.material:material-icons-extended:1.5.3")

    // Compose Foundation (for layouts, drawing, etc.)
    implementation("androidx.compose.foundation:foundation:1.5.3")

    // Compose UI (core Compose UI functionality)
    implementation("androidx.compose.ui:ui:1.5.3")  // Versión coherente

    // Tooling (for preview support in Android Studio)
    implementation("androidx.compose.ui:ui-tooling:1.5.3")
    debugImplementation("androidx.compose.ui:ui-tooling-preview:1.5.3")

    // Dagger 2
    annotationProcessor("com.google.dagger:dagger-compiler:2.44.2")
    implementation("com.google.dagger:dagger:2.44.2")
    implementation("com.google.dagger:dagger-android-support:2.44.2")
    compileOnly("javax.annotation:jsr250-api:1.0")
    implementation("javax.inject:javax.inject:1")

    // Room database
    implementation("androidx.room:room-runtime:2.2.5")
    annotationProcessor("androidx.room:room-compiler:2.2.5")
    testImplementation("androidx.room:room-testing:2.2.5")

    // Librerías comunes
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.ui.test.android)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.runtime.livedata)

    // Dependencias de prueba
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
