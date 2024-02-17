plugins {
    id("com.gradle.enterprise") version "3.10"
}

rootProject.name = "AsciidocDsl"

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}
