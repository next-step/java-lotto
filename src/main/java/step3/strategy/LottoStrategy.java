package step3.strategy;

import step3.domain.number.LottoNumber;
import step3.domain.number.LottoNumbers;

import java.util.List;

public interface LottoStrategy {
  LottoNumbers markingNumbers(List<LottoNumber> lottoNumbers);
}
