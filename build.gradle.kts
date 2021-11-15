import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
}

group = "me.timuryantimirov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.create<Jar>("fatJar"){
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(mapOf("Main-Class" to "RunnerKt")) // replace it with your own
    }
    val sourceMain = sourceSets.main.get()
    from(sourceMain.output)

    configurations.runtimeClasspath.get().filter {
        it.name.endsWith(".jar")
    }.forEach { jar ->
        from(zipTree(jar))
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}