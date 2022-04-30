package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoNumber;

public class FixedNumberGenerateStrategy implements NumberGenerateStrategy {

  @Override
  public List<LottoNumber> generate() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (int i = 1; i < 7; i++) {
      lottoNumbers.add(LottoNumber.create(i));
    }

    return lottoNumbers;
  }
}
