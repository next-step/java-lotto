package lotto;

import lotto.generator.LottoGenerator;
import lotto.generator.RandomNumberGenerator;

public class LottoNumber {
    private Integer lottoNumber;

    public LottoNumber() {
        this.lottoNumber = new LottoGenerator().getRandomNumber();
    }

    public LottoNumber(RandomNumberGenerator lottoNumberGenerator) {
        this.lottoNumber = lottoNumberGenerator.getRandomNumber();
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }
}
