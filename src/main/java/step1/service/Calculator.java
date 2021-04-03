package step1.service;

import step1.domain.Number;

import java.util.List;

public class Calculator {
  private final List<Number> numbers;

  public Calculator(List<Number> numberList) {
    this.numbers = numberList;
  }

  public int sum() {
    Number result = new Number();
    for (Number number : numbers) {
      result = number.sum(result);
    }

    return result.getNumber();
  }
}
