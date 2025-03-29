package lotto.strategy.shuffle;

import lotto.type.LottoNumber;

import java.util.Collections;
import java.util.List;

public class CollectionsShuffleStrategy implements ShuffleStrategy {

  @Override
  public List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
    Collections.shuffle(lottoNumbers);
    return lottoNumbers;
  }
}
