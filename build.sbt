name := """tapir-play-sample"""
organization := "com.github.gaeljw"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    publishArtifact := false
  )

publishTo := Some(Resolver.file("Unused transient repository", file("target/unusedrepo")))

scalaVersion := "2.13.12"

val tapirVersion = "1.8.2"

libraryDependencies += guice

// Tapir
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-core" % tapirVersion
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-play-server" % tapirVersion

// JSON handling (you can use Circe instead of Play-JSON)
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-json-play" % tapirVersion

// Tapir OpenAPI
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % tapirVersion

// Swagger UI
// You can also host Swagger UI by yourself and get rid of this dependency with more manual setup
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % tapirVersion

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test

// For Akka Streams (if using streaming)
libraryDependencies += "com.softwaremill.sttp.shared" %% "akka" % "1.3.16"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.github.gaeljw.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.github.gaeljw.binders._"
