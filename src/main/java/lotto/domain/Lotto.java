package lotto.domain;

public class Lotto {

    private final LottoNumberList lottoNumbers;

    public Lotto() {
        this(LottoNumberList.getLottoNumbers());
    }

    public Lotto(LottoNumberList lottoNumberList) {
        this.lottoNumbers = lottoNumberList;
    }

    public int match(Lotto lotto) {
        return lottoNumbers.match(lotto.numbers());
    }

    private LottoNumberList numbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
