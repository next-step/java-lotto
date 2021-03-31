package step2.domain.generator;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.Lottos;
import step2.exception.LottoShuffleNullPointerException;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

import java.util.*;

public final class LottoGenerateMachine {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    private final LottoShuffleStrategy lottoShuffleStrategy;

    private LottoGenerateMachine(LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoGenerateMachine of() {
        return of(LottoRandomShuffleStrategy.getInstance());
    }

    public static final LottoGenerateMachine of(LottoShuffleStrategy lottoShuffleStrategy) {
        validate(lottoShuffleStrategy);
        return new LottoGenerateMachine(lottoShuffleStrategy);
    }

    private static final void validate(LottoShuffleStrategy lottoShuffleStrategy) {
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
        List<LottoNumber> lottoNumbers = LottoNumber.values();
        lottoShuffleStrategy.shuffle(lottoNumbers);
        return Lotto.of(lottoNumbers.subList(FROM_INDEX, TO_INDEX));
    }


}
