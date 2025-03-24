package lotto.domain;

import java.util.Set;

public class Lotto {
  private final Set<Integer> numbers;

  public static final int SIZE = 6;
  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  public static final int PRICE = 1000;

  public Lotto(Set<Integer> numbers) {
    if (!validateChecks(numbers)) {
      throw new IllegalArgumentException("로또 번호가 유효하지 않습니다.");
    }

    this.numbers = numbers;
  }

  public boolean validateChecks(Set<Integer> numbers) {
    return numbers.size() == SIZE
        && numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
  }

  public static Lotto generateLotto(LottoGenerator lottoGenerator) {
    return lottoGenerator.generate();
  }

  public int size() {
    return numbers.size();
  }

  public Set<Integer> getNumbers() {
    return numbers;
  }

}
