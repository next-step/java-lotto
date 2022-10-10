package lotto.domain;

public class Lotto {

    private final LottoNumberList lottoNumbers;

    public Lotto() {
        this(LottoNumberList.getLottoNumbers());
    }

    public Lotto(LottoNumberList lottoNumberList) {
        this.lottoNumbers = lottoNumberList;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
