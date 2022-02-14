package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.strategy.GenerateStrategy;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final Lotto lotto;

    public LottoGenerator(GenerateStrategy strategy) {
        lotto = Lotto.from(new ArrayList<>(generatorLotto(strategy)));
    }

    public static LottoGenerator of(GenerateStrategy strategy) {
        return new LottoGenerator(strategy);
    }

    public Lotto getLotto() {
        return lotto;
    }

    private List<LottoNumber> generatorLotto(GenerateStrategy strategy) {
        List<LottoNumber> lotto = new ArrayList<>();

        while (lotto.size() < LOTTO_SIZE) {
            LottoNumber lottoNumber = LottoNumber.from(
                strategy.generateNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            );

            if (lottoNumber.isInLottoNumberList(lotto)) {
                continue;
            }
            lotto.add(lottoNumber);
        }

        return lotto;
    }
}
