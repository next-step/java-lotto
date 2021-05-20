package step3.domain;

import java.util.Collection;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(Collection<Integer> numbers) {
        lottoNumbers = new LottoNumbers(numbers);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(Collection<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
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
