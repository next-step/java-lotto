package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

  private final static int SIZE = 6;

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 숫자는 6개가 입력되어야 합니다. " + numbers);
    }

    this.numbers = new ArrayList<>(numbers);
  }

  public List<Integer> getNumbers() {
    return new ArrayList<>(numbers);
  }
}
