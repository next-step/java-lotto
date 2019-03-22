package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

  private final Set<Integer> numbers;

  public Lotto(Set<Integer> numbers) {

    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
    }

    if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
      throw new IllegalArgumentException();
    }

    this.numbers = numbers;
  }

  public Set<Integer> getNumbers() {
    return this.numbers;
  }

  public int winMatch(Set<Integer> winNumbers) {

    return (int)winNumbers.stream()
        .filter(numbers::contains)
        .count();
  }
}
