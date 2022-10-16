package lotto.domain.lotto;

public class Lotto {

    protected final LottoNumberSet lottoNumbers;

    public Lotto() {
        this(LottoNumberSet.createLottoNumberSet());
    }

    public Lotto(LottoNumberSet lottoNumberSet) {
        this.lottoNumbers = lottoNumberSet;
    }

    protected LottoNumberSet numbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
