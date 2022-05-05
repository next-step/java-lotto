package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoNumber;

public class DuplicateNumberGenerateStrategy implements LottoNumberGenerateStrategy {

  @Override
  public List<LottoNumber> generate() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (int i = 1; i < 7; i++) {
      lottoNumbers.add(LottoNumber.create(1));
    }

    return lottoNumbers;
  }
}
