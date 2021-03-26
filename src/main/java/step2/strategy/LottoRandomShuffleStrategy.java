package step2.strategy;

import step2.domain.Lotto.LottoNumber;

import java.util.Collections;
import java.util.List;

public final class LottoRandomShuffleStrategy implements LottoShuffleStrategy{

    @Override
    public void shuffle(List<LottoNumber> lotto) {
        Collections.shuffle(lotto);
    }
}
