lazy val commonSettings = Seq(
	organization := "rtsytems",
	version := "0.1.0",
	scalaVersion := "2.11.5"
)

lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.12.0"

lazy val root = (project in file (".")).
	settings(commonSettings: _*).
	settings(
		name := "Programming in Scala",
		maxErrors := 20,
		pollInterval := 1000,
		javaOptions += "-Xmx2g")

