package step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private LottoNumbers lottoNumbers;

    private Lotto() {
        lottoNumbers = LottoNumbers.create();
    }

    private Lotto(String[] splitNumbers) {
        lottoNumbers = LottoNumbers.of(splitNumbers);
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public static Lotto of(String[] splitNumbers) {
        return new Lotto(splitNumbers);
    }

    public int match(Lotto lotto) {
        return lottoNumbers.match(lotto.getLottoNumbers());
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
