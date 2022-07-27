package com.tlglearning.fizzbuzz.model;

import java.util.EnumSet;
import java.util.Set;

public class Analysis {

  static final String IVF ="Value was %,d: must be non-negative";
  /**
   *
   * @param value
   * @return
   * @throws IllegalArgumentException if{@code value <0}.
   */

  public Set<State> analyze(int value){

    if (value<0){
      throw new IllegalArgumentException(String.format(IVF, value ));
    }
    Set<State> result = EnumSet.noneOf(State.class);

    if (value % 3 == 0){
      result.add(State.FIZZ);
    }

    if(value % 5 ==0){
      result.add(State.BUZZ);
    }

    return result;

  }
  //this method will return a set of the
  // instances of State enum (fizz, buss)
}
