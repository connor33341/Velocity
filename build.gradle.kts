plugins {
    `java-library`
    //id("velocity-checkstyle") apply false
    id("velocity-spotless") apply false
    //id("maven-publish") apply false
}

subprojects {
    apply<JavaLibraryPlugin>()

    //apply(plugin = "velocity-checkstyle")
    apply(plugin = "velocity-spotless")
    /*apply(plugin = "maven-publish")
    configure<PublishingExtension> {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/connor33341/Velocity")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
                }
            }
            publications {
                register<MavenPublication>("gpr") {
                    from(components["java"])
                }
            }
        }
    }*/

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    dependencies {
        testImplementation(rootProject.libs.junit)
    }

    tasks {
        test {
            useJUnitPlatform()
            reports {
                junitXml.required.set(true)
            }
        }
    }
}
