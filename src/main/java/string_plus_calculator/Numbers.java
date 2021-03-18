package string_plus_calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

  private List<Number> numbers = new ArrayList<>();

  public Numbers() { }

  public Numbers(List<Number> numbers) {
    this.numbers = numbers;
  }

  public void add(Number number) {
    numbers.add(number);
  }

  public int sum() {
    int result = 0;
    for (Number number : numbers) {
      result = number.plus(result);
    }
    return result;
  }
}
