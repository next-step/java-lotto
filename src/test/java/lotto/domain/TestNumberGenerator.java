package lotto.domain;

import java.util.Arrays;
import java.util.List;

class TestNumberGenerator extends NumberGenerator {

  private List<Integer> numbers;

  TestNumberGenerator(
      int firstMatchNumber,
      int secondMatchNumber,
      int thirdMatchNumber,
      int fourthMatchNumber,
      int fifthMatchNumber,
      int sixthMatchNumber) {

    this.numbers = Arrays.asList(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        fifthMatchNumber,
        sixthMatchNumber
    );
  }

  @Override
  public List<Integer> generate() {
    return this.numbers;
  }
}
