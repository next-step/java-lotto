package lotto.strategy.shuffle;

import lotto.type.LottoNumber;

import java.util.List;

public interface ShuffleStrategy {
  List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers);
}
