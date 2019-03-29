package domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto (LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}
