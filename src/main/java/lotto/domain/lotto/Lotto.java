package lotto.domain.lotto;

import lotto.constants.Winning;
import lotto.domain.lotto.strategy.GenerateStrategy;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(GenerateStrategy strategy) {
        this.lottoNumbers = LottoNumbers.of(strategy.generate());
    }

    public static Lotto of(GenerateStrategy strategy) {
        return new Lotto(strategy);
    }

    public Winning match(Lotto jackpot) {
        long match = jackpot.lottoNumbers.match(lottoNumbers);
        return Winning.of(match);
    }

    public List<Integer> numbers() {
        return lottoNumbers.numbers();
    }
}
