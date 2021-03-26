package step2.strategy;

import step2.domain.Lotto.LottoNumber;

import java.util.Collections;
import java.util.List;

public final class LottoRandomShuffleStrategy implements LottoShuffleStrategy{

    private static LottoRandomShuffleStrategy instance;
    private LottoRandomShuffleStrategy(){

    }

    public static LottoRandomShuffleStrategy getInstance() {
        if(isInstanceNull()) {
            instance = new LottoRandomShuffleStrategy();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    @Override
    public void shuffle(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }
}
