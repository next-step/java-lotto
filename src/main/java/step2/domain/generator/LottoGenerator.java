package step2.domain.generator;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.strategy.LottoShuffleStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    private final LottoShuffleStrategy lottoShuffleStrategy;

    private LottoGenerator(LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoGenerator of(LottoShuffleStrategy lottoShuffleStrategy) {
        return new LottoGenerator(lottoShuffleStrategy);
    }

    public final Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = getAllLottoNumber();
        lottoShuffleStrategy.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        Collections.sort(lottoNumbers);
        return Lotto.of(lottoNumbers);
    }

    private final List<LottoNumber> getAllLottoNumber() {
        return new ArrayList<>(LottoNumber.getAllLottoNumber());
    }

}
