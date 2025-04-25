plugins {
    java
    `maven-publish`
}

extensions.configure<PublishingExtension> {
    repositories {
        maven {
            //credentials(PasswordCredentials::class.java)

            name = "github"
            url = uri("https://maven.pkg.github.com/connor33341/Velocity")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("githubUsername")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("githubPassword") //User Token
            }
        }
    }
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])
        }
        /*create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("Velocity")
                description.set("The modern, next-generation Minecraft server proxy")
                url.set("https://papermc.io/software/velocity")
                scm {
                    url.set("https://github.com/PaperMC/Velocity")
                    connection.set("scm:git:https://github.com/PaperMC/Velocity.git")
                    developerConnection.set("scm:git:https://github.com/PaperMC/Velocity.git")
                }
            }
        }*/
    }
}
