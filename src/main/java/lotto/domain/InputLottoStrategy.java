package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class InputLottoStrategy implements LottoStrategy {

  private final List<Integer> numbers;

  public InputLottoStrategy(List<Integer> numbers) {
    this.numbers = numbers;
  }

  @Override
  public List<LottoNumber> issue() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();

    for (int number : numbers) {
      lottoNumbers.add(new LottoNumber(number));
    }

    return lottoNumbers;
  }
}
