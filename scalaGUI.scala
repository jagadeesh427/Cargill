package scala

import scala.swing._
object FirstSwingApp extends SimpleSwingApplication{
  def top: MainFrame = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }
}

nname := "SCALA"

version := "0.1"

scalaVersion := "2.11.8"

scalacOptions += "-deprecation"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.1.1"

#############################################################################################

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


########## converting celsius to fahrenheit ###############

package scala

import swing._
import event._

object SecondSwingApp extends SimpleSwingApplication {
  def top: MainFrame = new MainFrame {
    title = "Celsius/Fahrenheit Converter"
    object celsius extends TextField { columns = 5 }
    object fahrenheit extends TextField { columns = 5 }
    contents = new FlowPanel {
      contents += celsius
      contents += new Label(" Celsius = ")
      contents += fahrenheit
      contents += new Label(" Fahrenheit")
      border = Swing.EmptyBorder(15, 10, 10, 10)
    }
    listenTo(celsius, fahrenheit)
    reactions += {
      case EditDone(`fahrenheit`) =>
        val f = fahrenheit.text.toInt
        val c = (f - 32) * 5 / 9
        celsius.text = c.toString
      case EditDone(`celsius`) =>
        val c = celsius.text.toInt
        val f = c * 9 / 5 + 32
        fahrenheit.text = f.toString
    }
  }
}

##############spreadsheet #############################

import swing._

class Spreadsheet(val height: Int, val width: Int)
  extends ScrollPane {
  val table = new Table(height, width) {
    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new java.awt.Color(150, 150, 150)
  }
  val rowHeader =
    new ListView((0 until height) map (_.toString)) {
      fixedCellWidth = 30
      fixedCellHeight = table.rowHeight
    }
  viewportView = table
  rowHeaderView = rowHeader
}

object Main extends SimpleSwingApplication {
  def top: MainFrame = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet(100, 26)
  }
}



