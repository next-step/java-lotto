package lotto.strategy;

import lotto.type.LottoNumber;

import java.util.List;

public interface LottoCreateStrategy {
  int pick(int min, int max);
  List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers);
}
