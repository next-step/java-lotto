package step4.strategy;

import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;

import java.util.List;

public interface LottoStrategy {
  LottoNumbers markingNumbers(List<LottoNumber> lottoNumbers);
}
