package step2.strategy;

import step2.domain.Lotto.LottoNumber;

import java.util.List;

public interface LottoShuffleStrategy {

    void shuffle(List<LottoNumber> lotto);
}
