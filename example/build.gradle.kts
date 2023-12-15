plugins {
    kotlin("jvm")
    id("com.ncorti.ktfmt.gradle")
    id("com.google.devtools.ksp") version "1.9.21-1.0.16"
    id("app.cash.sqldelight") version "2.0.1"
}

ktfmt {
    kotlinLangStyle()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.jupiter)
    testRuntimeOnly(libs.jupiter.platform.launcher)
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sqldelight {
  databases {
    create("Database") {
      packageName.set("com.example")
    }
  }
}
