package lotto.domain;

import java.util.Set;

public class Lotto {
  private final Set<Integer> numbers;

  private static final int LOTTO_SIZE = 6;
  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  public Lotto(Set<Integer> numbers) {
    if (!validateChecks(numbers)) {
      throw new IllegalArgumentException("로또 번호가 유효하지 않습니다.");
    }

    this.numbers = numbers;
  }

  public boolean validateChecks(Set<Integer> numbers) {
    return numbers.size() == LOTTO_SIZE
        && numbers.stream().allMatch(number -> number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER);
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
