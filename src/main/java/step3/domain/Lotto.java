package step3.domain;

import java.util.Collection;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(Collection<Integer> numbers) {
        this(new LottoNumbers(numbers));
    }

    public static Lotto of(Collection<Integer> numbers) {
        return new Lotto(numbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto.getLottoNumbers());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
