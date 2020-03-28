package lotto;

import lotto.generator.LottoGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.Objects;

public class LottoNumber {
    private Integer lottoNumber;

    public LottoNumber() {
        this.lottoNumber = new LottoGenerator().getRandomNumber();
    }

    public LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public LottoNumber(RandomNumberGenerator lottoNumberGenerator) {
        this.lottoNumber = lottoNumberGenerator.getRandomNumber();
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
