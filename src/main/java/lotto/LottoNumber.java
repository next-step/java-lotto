package lotto;

import lotto.generator.LottoGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private Integer lottoNumber;

    public LottoNumber() {
        this.lottoNumber = new LottoGenerator().getRandomNumber();
    }

    public LottoNumber(int number) {
        this.lottoNumber = number;
        validateNumberRange(this.lottoNumber);
    }

    public LottoNumber(String input) {
        this.lottoNumber = convertNumber(input);
        validateNumberRange(this.lottoNumber);
    }

    public LottoNumber(RandomNumberGenerator lottoNumberGenerator) {
        this.lottoNumber = lottoNumberGenerator.getRandomNumber();
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void validateNumberRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new RuntimeException("로또 숫자 범위를 넘어섰습니다.");
        }
    }

    private Integer convertNumber(String input) {
        Integer number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
        return number;
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
