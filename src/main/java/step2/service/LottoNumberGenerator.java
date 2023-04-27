package step2.service;

import step2.vo.BasicLottoNumbers;

public class LottoNumberGenerator {

    private final BasicLottoNumbers basicLottoNumbers;

    public LottoNumberGenerator() {
        this.basicLottoNumbers = new BasicLottoNumbers();
    }

    public Lotto generateLottoNumbers() {
        return basicLottoNumbers.pickSixNumbers();
    }
}
