package step2.strategy;

import step2.domain.number.LottoNumber;

import java.util.List;

public interface LottoStrategy {
  List<LottoNumber> markingNumbers(List<LottoNumber> lottoNumbers);
}
