package lotto;

import java.util.List;

public class Lotto {
  public static final int PRICE = 1000;

  private final List<LottoNumber> numbers;

  public Lotto(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }
}
