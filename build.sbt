organization := "hr.element.etb"

name         := "etb-slug"

version      := "0.0.3"

// ### Build settings ###

libraryDependencies ++= Seq(
  "com.ibm.icu" % "icu4j" % "51.1"
, "org.scalatest" %% "scalatest" % "2.0.M5b" % "test"
)

crossScalaVersions := Seq("2.10.1", "2.9.3", "2.9.2", "2.9.1-1", "2.9.1", "2.9.0-1", "2.9.0")

scalaVersion <<= crossScalaVersions(_.head)

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "UTF-8", "-optimise")

unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)( _ :: Nil)

unmanagedSourceDirectories in Test    <<= (scalaSource in Test   )( _ :: Nil)


// ### Publishing ###

publishTo := Some("Element Releases" at "http://repo.element.hr/nexus/content/repositories/releases/")

credentials += Credentials(Path.userHome / ".config" / "Sluggifier_master" / "nexus.config")

publishArtifact in (Compile, packageDoc) := false


// ### Misc ###

initialCommands := "import hr.element.doit.slug._"
