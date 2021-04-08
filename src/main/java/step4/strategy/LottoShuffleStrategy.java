package step4.strategy;

import step4.domain.lotto.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoShuffleStrategy {

    void shuffle(List<LottoNumber> lottoNumbers);

}
