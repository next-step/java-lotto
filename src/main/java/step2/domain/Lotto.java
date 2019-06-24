package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public Lotto(Lotto lotto) {
        this.lottoNumbers = lotto.getLottoNumbers();
    }

    public static Lotto create(LottoGenerator generator) {
        return generator.generate();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public LottoRank matchLotto(WinningLotto lotto) {
        final long matchCount = lottoNumbers.stream()
                                            .filter(number -> match(number, lotto.getLotto()))
                                            .count();

        return LottoRank.matchOf((int) matchCount);
    }

    private boolean match(final LottoNumber answerNumber, final Lotto lotto) {
        return lotto.lottoNumbers.contains(answerNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
