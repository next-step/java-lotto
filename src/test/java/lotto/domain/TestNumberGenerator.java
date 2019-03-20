package lotto.domain;

import java.util.Arrays;
import java.util.List;

class TestNumberGenerator extends NumberGenerator {

  private List<Number> numbers;

  TestNumberGenerator(
      int firstMatchNumber,
      int secondMatchNumber,
      int thirdMatchNumber,
      int fourthMatchNumber,
      int fifthMatchNumber,
      int sixthMatchNumber) {

    this.numbers = Arrays.asList(
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(thirdMatchNumber),
        new Number(fourthMatchNumber),
        new Number(fifthMatchNumber),
        new Number(sixthMatchNumber)
    );
  }

  @Override
  List<Number> generate() {
    return this.numbers;
  }
}
