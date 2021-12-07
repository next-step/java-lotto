package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    private final long matchedLottoNumbersCount;

    private Lotto(LottoNumbers lottoNumbers, long matchedLottoNumbersCount) {
        this.lottoNumbers = lottoNumbers;
        this.matchedLottoNumbersCount = matchedLottoNumbersCount;
    }

    public static Lotto from(List<Integer> input) {
        LottoNumbers lottoNumbers = LottoNumbers.from(input);
        return new Lotto(lottoNumbers, 0);
    }

    public static Lotto from(LottoNumbers input) {
        return new Lotto(input, 0);
    }

    public static Lotto from(LottoNumbers input, long matchedLottoNumbersCount) {
        return new Lotto(input, matchedLottoNumbersCount);
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers.values();
    }

    public Lotto match(LottoNumbers winningNumbers) {
        long newMatchedLottoNumbersCount = lottoNumbers.match(winningNumbers);
        return new Lotto(lottoNumbers, newMatchedLottoNumbersCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
