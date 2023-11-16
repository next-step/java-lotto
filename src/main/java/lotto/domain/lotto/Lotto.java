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
        return Winning.of(lottoNumbers.match(jackpot.lottoNumbers()));
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    public List<LottoNumber> numbers() {
        return lottoNumbers.numbers();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
