/*
 *  Copyright 2016 Magnus Madsen
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ca.uwaterloo.flix.api.dsl

object Combinators {

  implicit class UnpackHelper(thiz: AnyRef) {
    def as[T](c: Convert[T]): T = c.unpack(thiz)

    def ass[T](implicit c: Convert[T]): T = c.unpack(thiz)
  }

  sealed trait Convert[T] {
    def pack: T => AnyRef
    def unpack: AnyRef => T
  }

  implicit case object Int8 extends Convert[Byte] {
    def pack: (Byte) => AnyRef = ???
    def unpack: (AnyRef) => Byte = ???
  }

  case object Str extends Convert[String] {
    def pack: (String) => AnyRef = ???
    def unpack: (AnyRef) => String = ???
  }

  case class Tuple2[A, B](o1: Convert[A], o2: Convert[B]) extends Convert[(A, B)] {
    def pack: ((A, B))=> AnyRef = ???
    def unpack: (AnyRef) => (A, B) = ???
  }

  case class Lst[T](o: Convert[T]) extends Convert[List[T]] {
    def pack: (List[T]) => AnyRef = ???
    def unpack: (AnyRef) => List[T] = ???
  }

  val foo: AnyRef = ???

  val bar: List[(Byte, String)] = Lst(Tuple2(Int8, Str)).unpack("foo")

  var faz = foo.as(Tuple2(Int8, Str))



  var qux = foo.ass[Byte]

}
