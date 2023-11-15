package lotto.domain.lotto;

import lotto.constants.Winning;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public Winning match(Lotto jackpot) {
        long match = jackpot.lottoNumbers.match(lottoNumbers);
        return Winning.of(match);
    }

    public List<Integer> numbers() {
        return lottoNumbers.numbers();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
