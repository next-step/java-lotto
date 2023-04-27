package step2.service;

public class LottoNumberGenerator {

    private final BasicLottoNumbers basicLottoNumbers;

    public LottoNumberGenerator() {
        this.basicLottoNumbers = new BasicLottoNumbers();
    }

    public Lotto generateLottoNumbers() {
        return basicLottoNumbers.pickSixNumbers();
    }
}
