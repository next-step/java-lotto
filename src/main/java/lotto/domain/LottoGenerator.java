package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.GenerateStrategy;

public class LottoGenerator {

    private static final int GENERATE_MIN_NUMBER = 1;
    private static final int GENERATE_MAX_NUMBER = 45;

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

        while (lotto.size() < Lotto.LOTTO_MAX_SIZE) {
            LottoNumber lottoNumber = LottoNumber.from(
                strategy.generateNumber(GENERATE_MIN_NUMBER, GENERATE_MAX_NUMBER)
            );

            if (lottoNumber.isInLottoNumberList(lotto)) {
                continue;
            }
            lotto.add(lottoNumber);
        }

        return lotto;
    }
}
