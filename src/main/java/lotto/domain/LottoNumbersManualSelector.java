package lotto.domain;

import java.util.List;

public class LottoNumbersManualSelector implements LottoNumbersSelector {

  private final List<LottoNumber> numbers;

  public LottoNumbersManualSelector(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  @Override
  public List<LottoNumber> selectBy(int number) {
    return numbers.subList(0, number);
  }
}
