package code.snippet

import scala.xml.NodeSeq
import net.liftweb.http.js.JsCmds
import net.liftweb.http.SHtml
import net.liftweb.util.BaseField
import net.liftweb.util.FieldContainer
import net.liftweb.util.Helpers._
import net.liftweb.http.S
import net.liftweb.http.LiftScreen
import net.liftweb.http.PageName
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers
import net.liftweb.common.Full
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.StringField
import code.model.MyField

class Buttons {

  // providing the model
  val container1 = new FieldContainer {
    override def allFields: Seq[BaseField] =
      List(new MyField("container1_test1"), new MyField("container1_test2"))
  }

  val container2 = new FieldContainer {
    override def allFields: Seq[BaseField] =
      List(new MyField("container2_test1"), new MyField("container2_test2"))
  }

  def handle(id: String) = {
    println(id)
    val c = { if (id == 1) container1 else container2 }

    // setting the model + rendering the form 
    code.snippet.Model.withValue(Full(c)) {
      JsCmds.SetHtml("myform", <div data-lift="MyLiftScreen"></div>)
    }
  }

  def render(in: NodeSeq): NodeSeq = {
    // put edit buttons in place 
    <div>
      {
        for (i <- 1 to 2) yield {
          ("* [onclick]" #> SHtml.ajaxCall(JsRaw(i.toString), m => handle(m))) apply (
            <button>Edit { i }</button>)
        }
      }
    </div>
    <div id="myform"></div>
  }

}