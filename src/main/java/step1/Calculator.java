package step1;

import step1.domain.Number;

import java.util.List;

public class Calculator {
  private final List<Number> numberList;

  public Calculator(List<Number> numberList) {
    this.numberList = numberList;
  }

  public int sum() {
    Number result = new Number();
    for (Number number : numberList) {
      result = number.sum(result);
    }

    return result.getNumber();
  }
}
