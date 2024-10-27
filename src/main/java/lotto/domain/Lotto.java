package lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoNumbers.generateLotto();
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
