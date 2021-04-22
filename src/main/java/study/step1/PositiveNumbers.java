package study.step1;

import java.util.List;

public class PositiveNumbers {

  private final List<Integer> numbers;

  public PositiveNumbers(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public int sum() {
    return numbers.stream().mapToInt(i -> i).sum();
  }

  public void validatorNumbers() {
    boolean result = numbers.stream().anyMatch(number -> number < 0);

    if (result) {
      throw new RuntimeException();
    }
  }

}
