name := """stocks_analyzer_batch"""

version := "1.0.0-core_1.0"

lazy val core = (project in file("modules/stocks_analyzer_core")).enablePlugins(PlayJava).settings(javacOptions in (Compile,doc) += "-Xdoclit:none")

lazy val root = (project in file(".")).enablePlugins(PlayJava).dependsOn(core).aggregate(core).settings(javacOptions in (Compile,doc) ++= Seq("-notimestamp", "-linksource"))

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.skipParents in ThisBuild := false