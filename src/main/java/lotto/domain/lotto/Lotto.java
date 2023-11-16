package lotto.domain.lotto;

import lotto.constants.Winning;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public Winning match(Lotto jackpot) {
        return Winning.of(lottoNumbers.match(jackpot.lottoNumbers()));
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }


    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
