package com.tlglearning.fizzbuzz;

import com.tlglearning.fizzbuzz.model.Analysis;
import com.tlglearning.fizzbuzz.model.State;
import java.util.Set;
import org.apache.commons.cli.Options;

public class FizzBuzz {

  private static final int DEFAULT_UPPER_BOUND = 100;
  //only static finals can be constatnts
//  every constat is a stic final,no excpetions , but notevery sttaic final is a constant
//  e.g. a static final int cannto be reassigned to another int
//  but a static final array of ints, you are pointing to a specific "address" (that array)
//  so changing a single value within the array, for example, isn't changing what the value is pointing '

  public static void main(String[] args) {
    try {
      int upperBound = (args.length>0) ? Integer.parseInt(args[0]) : DEFAULT_UPPER_BOUND;
      if(upperBound<=0){
          throw new IllegalArgumentException();
        }
      Analysis analysis = new Analysis();
      for (int counter = 1; counter <= upperBound; counter++) {
        Set<State> result = analysis.analyze(counter);
        //use command + click to figure out ^^
        System.out.println(result.isEmpty() ? counter : result);

        }
    } catch (IllegalArgumentException e) {
      System.out.printf("Usage: Java %1$s [upperBound]%n", FizzBuzz.class.getName() );
      System.out.println("Where: upperBound is a positive integer with a default of 100");
    }finally {
      System.out.println("Thanks for playing!");
    }
  }
  }
