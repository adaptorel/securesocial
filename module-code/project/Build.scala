import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "securesocial"
    val appVersion      = "0.9.47"

    val appDependencies = Seq(
      "com.typesafe" %% "play-plugins-util" % "2.1.0",
      "com.typesafe" %% "play-plugins-mailer" % "2.1.0",
      "org.mindrot" % "jbcrypt" % "0.3m",
      "com.google.guava" % "guava" % "14.0.1",
      "junit" % "junit-dep" % "4.11"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
    ).settings(
      publishMavenStyle := false,
      resolvers ++= Seq(
        "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
      ),
      publishTo <<= (version) { version: String =>
	  val scalasbt = "/Users/dorel/Work/_sbt-repos"
   	  val (name, url) = if (version.contains("-SNAPSHOT"))
     	  ("snapshots", scalasbt+"/snapshots")
   	  else
          ("releases", scalasbt+"/releases")
         Some(Resolver.file(name, new File(url))(Resolver.ivyStylePatterns))
      }    
    )

}
