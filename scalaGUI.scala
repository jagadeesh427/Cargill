
import scala.swing._

object FirstSwingApp extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }
}


sbt:

name := "SCALA"

version := "0.1"

scalaVersion := "2.11.8"

scalacOptions += "-deprecation"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.11.8"




####

import scala.swing._

new Frame {
  title = "Hello world"
  
  contents = new FlowPanel {
    contents += new Label("Launch rainbows:")
    contents += new Button("Click me") {
      reactions += {
        case event.ButtonClicked(_) =>
          println("All the colours!")
      }
    }
  }
  
  pack()
  centerOnScreen()
  open()
}
