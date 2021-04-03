package step2.strategy;

import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;

import java.util.List;

public interface LottoStrategy {
  LottoNumbers markingNumbers(List<LottoNumber> lottoNumbers);
}
