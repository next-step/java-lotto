package domain;

public class Lotto {
    private LottoNumbers lottoNumbers = new LottoNumbers();

    public Lotto () {}

    private Lotto (LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto getInstance() {
        return new Lotto(lottoNumbers.makeLotto());
    }

}
