package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {

  private static final int LOTTO_NUMBER_LIMIT_SIZE = 6;

  private final List<Number> numbers;
  private int matchCount;

  public UserLotto(List<Number> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  public UserLotto(List<Number> numbers, WinningLotto winningLotto) {
    validate(numbers);
    this.numbers = numbers;
    this.matchCount = initMatchCount(winningLotto);
  }

  private int initMatchCount(WinningLotto winningLotto) {
    int matchCount = 0;
    for(Number winningNumber : winningLotto.getNumbers()) {
      matchCount += isMatch(winningNumber) ? 1 : 0;
    }
    return matchCount;
  }

  private boolean isMatch(Number winningNumber) {
    return this.numbers.stream()
        .anyMatch(number -> number.get() == winningNumber.get());
  }

  private void validate(List<Number> numbers) {
    if (numbers.size() != LOTTO_NUMBER_LIMIT_SIZE) {
      throw new IllegalArgumentException();
    }
  }

  public List<Number> getNumbers() {
    return this.numbers;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  @Override
  public String toString() {
    return numbers.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
