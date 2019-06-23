package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto create(LottoGenerator generator) {
        return generator.generate();
    }

    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public LottoRank matchLotto(WinningLotto lotto) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            matchCount += match(number, lotto.getLotto());
        }
        return LottoRank.matchOf(matchCount);
    }

    private int match(int answerNumber, Lotto lotto) {
        if (lotto.lottoNumbers.contains(answerNumber)) {
            return 1;
        }
        return 0;
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
