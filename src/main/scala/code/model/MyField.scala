package code.model

import scala.annotation.meta.field
import net.liftweb.util.BaseField
import net.liftweb.util.FieldError
import net.liftweb.common.Box
import scala.xml.NodeSeq
import scala.annotation.meta.field
import net.liftweb.common.Full
import net.liftweb.http.LiftRules

class MyField[T](value: String)(implicit manifest: Manifest[T]) extends BaseField {

  type ValueType = String

  def name: String = value

  def setFilter: List[ValueType => ValueType] = {
    List()
  }

  def validations: List[ValueType => List[FieldError]] = {
    List()
  }

  def validate: List[FieldError] = {
    List()
  }

  def toForm: Box[NodeSeq] = {
    Full(<input type="text" value={ value.toString() }></input>)
  }

  def set(in: ValueType): ValueType = {
    println("set is called")
    in
  }

  def get: ValueType = {
    println("get is called")
    ""
  }

  @deprecated("Use get", "2.4")
  def is = get

}