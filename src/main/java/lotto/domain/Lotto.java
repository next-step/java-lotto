package lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
