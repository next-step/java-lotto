package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Lotto.LOTTO_NUMBER_END;
import static lotto.domain.Lotto.LOTTO_NUMBER_START;

public class LottoAutoStrategy implements LottoGenerationStrategy {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final int lottoCount;
    
    public LottoAutoStrategy(int lottoCount) {
        this.lottoCount = lottoCount;
    }
    
    @Override
    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(getLotto());
        }

        return lottos;
    }

    private static Lotto getLotto() {
        return new Lotto(new Random().ints(LOTTO_NUMBER_START, LOTTO_NUMBER_END + 1)
            .distinct()
            .limit(LOTTO_NUMBER_COUNT)
            .boxed()
            .sorted()
            .map(LottoNo::new)
            .collect(toList()));
    }
}
