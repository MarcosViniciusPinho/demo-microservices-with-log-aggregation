import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.microservices"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2021.0.6"

configurations.all {
	exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")

	//Dependencies Kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//Dependency openfeign
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

	//Dependencies Logs
	implementation("org.apache.logging.log4j:log4j-api-kotlin:1.2.0")
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	implementation("co.elastic.logging:log4j2-ecs-layout:1.4.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
