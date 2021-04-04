package step3.strategy;

import step3.domain.lotto.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoShuffleStrategy {

    void shuffle(List<LottoNumber> lottoNumbers);

}
