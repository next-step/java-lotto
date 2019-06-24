package lotto.model;

import java.util.List;

public class Lotto {

  private final List<Integer> generatedNumbers;

  public Lotto(List<Integer> generatedNumbers) {
    this.generatedNumbers = generatedNumbers;
  }

  @Override
  public String toString() {
    return generatedNumbers.toString();
  }
}
