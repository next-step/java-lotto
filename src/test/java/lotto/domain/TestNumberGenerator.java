package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TestNumberGenerator extends NumberGenerator {

  private Set<Integer> numbers;

  TestNumberGenerator(
      int firstMatchNumber,
      int secondMatchNumber,
      int thirdMatchNumber,
      int fourthMatchNumber,
      int fifthMatchNumber,
      int sixthMatchNumber) {

    this.numbers = new HashSet<>(Arrays.asList(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        fifthMatchNumber,
        sixthMatchNumber
    ));
  }

  @Override
  public Set<Integer> generate() {
    return this.numbers;
  }
}
