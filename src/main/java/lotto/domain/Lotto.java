package lotto.domain;

public class Lotto {

    private final LottoNumberSet lottoNumbers;

    public Lotto() {
        this(LottoNumberSet.getLottoNumbers());
    }

    public Lotto(LottoNumberSet lottoNumberSet) {
        this.lottoNumbers = lottoNumberSet;
    }

    public int match(Lotto lotto) {
        return lottoNumbers.match(lotto.numbers());
    }

    private LottoNumberSet numbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
