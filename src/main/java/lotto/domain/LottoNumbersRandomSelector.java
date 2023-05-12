package lotto.domain;

import java.util.List;

public class LottoNumbersRandomSelector implements LottoNumbersSelector {

  @Override
  public List<LottoNumber> selectBy(int number) {
    return LottoNumbers.collectBySize(number);
  }
}
