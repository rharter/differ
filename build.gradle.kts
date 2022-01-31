buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    val kotlin_version: String by rootProject
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    group = project.property("GROUP") as String
    version = project.property("VERSION_NAME") as String
}

subprojects {


    tasks.withType<JavaCompile>().configureEach {
      sourceCompatibility = JavaVersion.VERSION_1_8.toString()
      targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

//    tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile).configureEach {
//      kotlinOptions {
//        jvmTarget = "1.8"
//      }
//    }

    repositories {
        mavenCentral()
    }
}

tasks.register("printOsName") {
    doLast {
        println("os.name: ${System.getProperties().propertyNames().toList().sortedBy { it as String }.map { "\n  $it: ${System.getProperty(it as String)}" }}")
    }
}