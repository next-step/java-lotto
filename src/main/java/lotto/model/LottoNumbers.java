package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    LottoValidationUtils.checkLottoNumberSize(numbers);
    LottoValidationUtils.checkLottoNumberRange(numbers);

    this.numbers = new ArrayList<>(numbers);
  }

  public List<Integer> values() {
    return new ArrayList<>(numbers);
  }
}
