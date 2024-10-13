package lotto.domain;

import java.util.Objects;

public class Lotto {

    private static final int PER_COST = 1_000;

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this(new LottoNumbers());
    }

    public Lotto(Integer... numbers) {
        lottoNumbers = new LottoNumbers(numbers);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto pickLottoNumber() {
        return new Lotto(lottoNumbers.pickNumbers());
    }

    public int calculateCount(int money) {
        return money / PER_COST;
    }

    public Rank match(WinNumber winnerNumber, LottoNumber bonus) {
        return lottoNumbers.calculateRank(winnerNumber, bonus);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Lotto))
            return false;
        Lotto that = (Lotto)o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
