plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")

}

android {
    compileSdk =31

    defaultConfig {
        applicationId =("om.example.samplechallengeino")
        minSdk =21
        targetSdk =31
        versionCode =1
        versionName =("1.0")

        testInstrumentationRunner =("androidx.test.runner.AndroidJUnitRunner")
    }
    buildFeatures{
        viewBinding =true
        //dataBinding= true
    }
    buildTypes{
        getByName("debug"){
            isMinifyEnabled=false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget ="1.8"

    }
}
dependencies {

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation ("androidx.recyclerview:recyclerview:1.3.0-alpha01")

//navigation component
    implementation ("androidx.navigation:navigation-fragment:2.4.0-beta02")
    implementation ("androidx.navigation:navigation-ui:2.4.0-beta02")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")

 //hilt
    implementation ("com.google.dagger:hilt-android:2.40.5")
    kapt ("com.google.dagger:hilt-compiler:2.40.5")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0") //added for test run code
    implementation ("androidx.fragment:fragment-ktx:1.4.0")
    implementation ("androidx.activity:activity-ktx:1.4.0")
//retro

    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //coroutines core
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-RC")

//test
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}
