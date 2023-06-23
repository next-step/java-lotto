package lotto.domain;

import java.util.List;

public class LottoNumbersRandomSelector implements LottoNumbersSelector {

  private static LottoNumbersRandomSelector instance = new LottoNumbersRandomSelector();

  private LottoNumbersRandomSelector() {}

  public static LottoNumbersRandomSelector getInstance() {
    return instance;
  }

  @Override
  public List<LottoNumber> selectBy(int number) {
    return LottoNumbers.collectBySize(number);
  }
}
