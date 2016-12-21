import Bool._
import Nat._
import List._

object NatTest {
  implicitly[_2 + _3 =:= _5]

  implicitly[_2 == _2 =:= True]
  implicitly[_2 == _3 =:= False]

  implicitly[_2 <= _3 =:= True]
  implicitly[_3 <= _3 =:= True]
  implicitly[_4 <= _3 =:= False]

  implicitly[_3 >= _3 =:= True]
  implicitly[_3 >= _2 =:= True]
  implicitly[_2 >= _3 =:= False]

  implicitly[_2 < _3 =:= True]
  implicitly[_3 < _3 =:= False]

  implicitly[_4 > _3 =:= True]
  implicitly[_3 > _3 =:= False]

  implicitly[_4 min _3 =:= _3]
  implicitly[_1 min _4 =:= _1]

  implicitly[_4 max _3 =:= _4]
  implicitly[_1 max _4 =:= _4]
}

object BoolTest {
  implicitly[True || False =:= ![False]]
  implicitly[ifb[True, False, True] =:= False]
}

object MapTest {
  type given    = _3 :: _1 :: _2 :: _4 :: _0 :: Nil
  type expected = _4 :: _2 :: _3 :: _5 :: _1 :: Nil
  type result   = given map ({ type F[N <: Nat] = N + _1 })#F

  implicitly[expected =:= result]
}

object ReduceTest {
  type given    = _1 :: _1 :: _0 :: _2 :: _1 :: _0 :: Nil
  type expected = _5
  type result   = given reduce ({ type F[N <: Nat, A <: Nat] = N + A })#F

  implicitly[expected =:= result]
}

object FilterTest {
  type given    = _1 :: _2 :: _0 :: _2 :: _3 :: _5 :: _4 :: _1 :: Nil
  type expected = _1 :: _2 :: _0 :: _2 :: _3 :: _1 :: Nil
  type result   = given filter ({ type F[N <: Nat] = N <= _3 })#F

  implicitly[expected =:= result]
}

object RemoveTest {
  type given    = _1 :: _2 :: _3 :: _2 :: Nil
  type expected = _1 :: _2 :: _2 :: Nil
  type result   = given remove _3

  implicitly[expected =:= result]
}

object SortedTest {
  type given    = _0 :: _5 :: _3 :: _4 :: _2 :: _1 :: Nil
  type expected = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: Nil
  type result   = sorted[given]

  implicitly[expected =:= result]
}

object ConcatTest {
  type givenLeft  = _0 :: _2 :: _1 :: Nil
  type givenRight = _4 :: _3 :: _5 :: Nil
  type expected   = _0 :: _2 :: _1 :: _4 :: _3 :: _5 :: Nil
  type result     = givenLeft ::: givenRight

  implicitly[expected =:= result]
}

object ReversedTest {
  type given    = _0 :: _1 :: _2 :: _3 :: Nil
  type expected = _3 :: _2 :: _1 :: _0 :: Nil
  type result   = reversed[given]

  implicitly[expected =:= result]
}

object SumTest {
  type given    = _0 :: _1 :: _2 :: _3 :: Nil
  type expected = _6
  type result   = sum[given]

  implicitly[expected =:= result]
}
