package lotto.domain;

import java.util.List;

public class Lotto {

  private List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return this.numbers;
  }

  public int winMatch(List<Integer> winNumbers) {

    return (int)winNumbers.stream()
        .filter(winNumber -> numbers.contains(winNumber))
        .count();
  }
}
