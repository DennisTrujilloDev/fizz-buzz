package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

class AnalysisTest {


  private Analysis analysis;
  Set<State> expected;

  //empty set: EnumSet.noneOf(State.class)
  @BeforeEach
  //@before is for methods
  public void setUp(){
    analysis = new Analysis();
  }
  //the analysis variable can also be declared and initialized as
  //a field up top

  @ParameterizedTest
  @ValueSource(ints = {3, 999_999_999})
  void analyze_fizz(int value) {
    expected = EnumSet.of(State.FIZZ);
    //divisible by 3 should say "FIZZ"
    assertEquals(expected, analysis.analyze(value));
    //look up what it means for sets to be equal
  }
  //testing four different test units:
  //fizz, buzz, fizzbuzz, neither

  @ParameterizedTest
  @ValueSource(ints = {0, 15, 999_999_990})
  void analyze_fizzBuzz(int value) {
    expected = EnumSet.of(State.FIZZ, State.BUZZ);
    assertEquals(expected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 85, 10, 999_999_985})
  void analyze_buzz(int value) {
    expected = EnumSet.of(State.BUZZ);
    assertEquals(expected, analysis.analyze(value));
  }

  @ParameterizedTest
//  @ValueSource(ints = {-1, 7, 999_999_998, -999_999_994})
  @CsvFileSource(resources = "neither.csv", numLinesToSkip = 1)
  void analyze_neither (int value) {
    expected = EnumSet.noneOf(State.class);
    assertEquals(expected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -3, -5, -15})
  void analyze_negative(int value){
    try{
      analysis.analyze(value);
      //If we reach this line, it didnt throw exception
      //it should jump to catch immediately after invokation above
    }catch(IllegalArgumentException e){
      //Do nothing; this is expected behavior
    }
  }
}