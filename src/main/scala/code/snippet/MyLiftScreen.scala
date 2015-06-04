package code.snippet

import scala.util.DynamicVariable
import net.liftweb.common.Box
import net.liftweb.util.FieldContainer
import net.liftweb.http.LiftScreen
import net.liftweb.http.TransientSnippet

object Model extends DynamicVariable[Box[FieldContainer]](None)

class MyLiftScreen extends LiftScreen with TransientSnippet {

  Model.value.map {
    container => this.addFields(() => container)
  }
  
  override def transient_? = true

  override def defaultToAjax_? = true
  
  override def finish() {
    println("finish")
  }
  
  
}