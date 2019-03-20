package lotto.domain;

import java.util.List;

public class Lotto {

  private List<Number> numbers;

  public Lotto(List<Number> numbers) {
    this.numbers = numbers;
  }

  public List<Number> getNumbers() {
    return this.numbers;
  }

  public int winMatch(List<Number> winNumbers) {

    return (int)winNumbers.stream()
        .filter(winNumber -> numbers.contains(winNumber))
        .count();
  }
}
