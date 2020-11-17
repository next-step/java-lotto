package domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto (LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto() {
        return new Lotto(new LottoNumbers().shuffleNumbers());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

}
