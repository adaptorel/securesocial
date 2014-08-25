import play.Project._

name := "securesocial"

//snmt -> share nothing / multitenant
version := "2.1.3.4-snmt"

libraryDependencies ++= Seq(
  cache,
  "com.typesafe" %% "play-plugins-util" % "2.2.0",
  "com.typesafe" %% "play-plugins-mailer" % "2.2.0",
  "org.mindrot" % "jbcrypt" % "0.3m"
)

resolvers ++= Seq(
  Resolver.typesafeRepo("releases")
)

publishMavenStyle := true

publishTo in ThisBuild := {
  val localPublishRepo = "/Users/dorel/Work/_bitbucket_maven"
  Some(Resolver.file("releases", new File(localPublishRepo)))
}

scalacOptions := Seq("-feature", "-deprecation")

playScalaSettings

