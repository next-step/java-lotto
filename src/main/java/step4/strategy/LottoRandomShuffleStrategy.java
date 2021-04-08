package step4.strategy;

import step4.domain.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class LottoRandomShuffleStrategy implements LottoShuffleStrategy {

    private static LottoRandomShuffleStrategy instance;

    private LottoRandomShuffleStrategy() { }

    public static final LottoRandomShuffleStrategy getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LottoRandomShuffleStrategy();
        }
        return instance;
    }


    @Override
    public void shuffle(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

}
