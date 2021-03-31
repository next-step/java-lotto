package step2.domain.generator;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.Lottos;
import step2.exception.LottoShuffleNullPointerException;
import step2.strategy.LottoShuffleStrategy;

import java.util.*;

public final class LottoGenerator {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    private final LottoShuffleStrategy lottoShuffleStrategy;

    private LottoGenerator(LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoGenerator from(LottoShuffleStrategy lottoShuffleStrategy) {
        validate(lottoShuffleStrategy);
        return new LottoGenerator(lottoShuffleStrategy);
    }

    private static void validate(LottoShuffleStrategy lottoShuffleStrategy) {
        if (Objects.isNull(lottoShuffleStrategy)) {
            throw new LottoShuffleNullPointerException();
        }
    }

    public final Lottos generateLottos(LottoGenerateCount generateCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (generateCount.hasNext()) {
            lottos.add(generateLotto());
            generateCount.next();
        }
        return Lottos.of(lottos);
    }

    private final Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = getLottoNumberValues();
        lottoShuffleStrategy.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        Collections.sort(lottoNumbers);
        return Lotto.of(lottoNumbers);
    }

    private final List<LottoNumber> getLottoNumberValues() {
        return new ArrayList<>(LottoNumber.values());
    }

}
