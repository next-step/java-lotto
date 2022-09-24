package lotto.step2.domain.strategy.shufflestrategy;

import lotto.step2.domain.LottoNumber;

import java.util.List;

public interface ShuffleStrategy {
    List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers);
}
