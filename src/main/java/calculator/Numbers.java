package calculator;

import java.util.List;

public class Numbers {

  private List<Number> numberList;

  public Numbers(List<Number> numberList) {
    this.numberList = numberList;
  }

  public int continuousSum() {
    return this.numberList.stream()
               .reduce((number, number2) -> number.sum(number2))
               .orElseThrow(IllegalArgumentException::new)
               .getValue();
  }

  public boolean isSizeEquals(int size) {
    return this.numberList.size() == size;
  }

  public int getValue(int index) {
    return this.numberList.get(index).getValue();
  }

}
