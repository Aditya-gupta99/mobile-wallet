import org.mifospay.MifosBuildType

plugins {
    alias(libs.plugins.mifospay.android.application)
    alias(libs.plugins.mifospay.android.application.compose)
    alias(libs.plugins.mifospay.android.application.flavors)
    alias(libs.plugins.mifospay.android.hilt)
    alias(libs.plugins.mifospay.android.application.firebase)
    id("com.google.android.gms.oss-licenses-plugin")
    alias(libs.plugins.roborazzi)
}

apply(from = "../config/quality/quality.gradle")

android {
    namespace = "org.mifospay"
    defaultConfig {
        applicationId = "org.mifospay"
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        debug {
            // applicationIdSuffix = MifosBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = true
            // applicationIdSuffix = MifosBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.core.data)
    implementation(libs.androidx.constraintlayout)

    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.swiperefresh.layout)

//    implementation("androidx.vectordrawable:vectordrawable-animated:1.1.0")
//    implementation("androidx.media:media:1.6.0")
//    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    api("com.google.android.material:material:1.0.0") // update require alot of UI changes

    implementation(projects.feature.receipt)
    implementation(projects.feature.profile)
    implementation(projects.feature.auth)
    implementation(projects.feature.passcode)
    implementation(projects.feature.makeTransfer)
    implementation(projects.feature.faq)
    implementation(projects.feature.editpassword)
    implementation(projects.feature.notification)
    implementation(projects.feature.requestMoney)
    implementation(projects.feature.upiSetup)
    implementation(projects.feature.settings)
    implementation(projects.feature.savedcards)
    implementation(projects.feature.qr)
    implementation(projects.feature.invoices)
    implementation(projects.feature.merchants)
    implementation(projects.feature.history)
    implementation(projects.feature.kyc)
    implementation(projects.feature.home)
    implementation(projects.feature.accounts)
    implementation(projects.feature.finance)
    implementation(projects.feature.payments)
    implementation(projects.feature.sendMoney)
    implementation(projects.feature.standingInstruction)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)
    implementation(libs.androidx.material.navigation)
    implementation(libs.accompanist.pager)

    implementation(libs.mifosPasscode)

    ksp(libs.hilt.compiler)

    // we need it for country picker library
//    implementation("androidx.compose.material:material:1.6.0")
//    implementation(libs.compose.country.code.picker) // remove after moving auth code to module

    // Google Bar code scanner
    implementation(libs.google.play.services.code.scanner)

    //calender for date picking
    implementation(libs.sheets.compose.dialogs.core)
    implementation(libs.sheets.compose.dialogs.calender)

    // ViewModel
    implementation(libs.androidx.lifecycle.ktx)
    implementation(libs.androidx.lifecycle.extensions)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Splash API
    implementation(libs.androidx.core.splashscreen)

    runtimeOnly(libs.androidx.compose.runtime)
    debugImplementation(libs.androidx.compose.ui.tooling)

//    implementation(libs.squareup.retrofit2) {
//        // exclude Retrofit’s OkHttp peer-dependency module and define your own module import
//        exclude(module = "okhttp")
//    }
//    implementation(libs.squareup.retrofit.adapter.rxjava)
//    implementation(libs.squareup.retrofit.converter.gson)
//    implementation(libs.squareup.okhttp)
//    implementation(libs.squareup.logging.interceptor)
//
//    implementation(libs.android.pdf.viewer)
//
//    implementation(libs.reactivex.rxjava.android)
//    implementation(libs.reactivex.rxjava)
//
//    implementation("io.michaelrocks:libphonenumber-android:8.11.0")
//
//    implementation("me.dm7.barcodescanner:zxing:1.9.13")
//    implementation("com.journeyapps:zxing-android-embedded:4.2.0")

    implementation(libs.mifosPasscode)

//    // Coil
//    implementation("io.coil-kt:coil-compose:2.6.0")
//
//    implementation("com.google.android.gms:play-services-auth:20.7.0")
//
//    implementation("com.hbb20:ccp:2.2.0")
//    implementation("com.github.MdFarhanRaja:SearchableSpinner:1.9")
//    implementation("com.alimuzaffar.lib:pinentryedittext:1.3.1")
//    implementation("de.hdodenhof:circleimageview:3.1.0")
//    implementation("com.github.yalantis:ucrop:2.2.2")

    kspTest(libs.hilt.compiler)

    testImplementation(libs.junit)
    testImplementation(libs.hilt.android.testing)

    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.hilt.android.testing)
}

dependencyGuard {
    configuration("prodReleaseRuntimeClasspath")
}
