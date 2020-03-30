package lotto.domain;

import lotto.generator.LottoGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.Objects;

public class LottoNumber implements Cloneable {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private Integer lottoNumber;

    public static LottoNumber newRandomNumber() {
        return new LottoNumber();
    }

    public static LottoNumber newRandomNumber(RandomNumberGenerator lottoNumberGenerator) {
        return new LottoNumber(lottoNumberGenerator);
    }

    public static LottoNumber newChooseNumber(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber newChooseNumber(String input) {
        return new LottoNumber(input);
    }

    private LottoNumber() {
        this.lottoNumber = new LottoGenerator().getRandomNumber();
    }

    private LottoNumber(int number) {
        this.lottoNumber = number;
        validateNumberRange(this.lottoNumber);
    }

    private LottoNumber(String input) {
        this.lottoNumber = convertNumber(input);
        validateNumberRange(this.lottoNumber);
    }

    private LottoNumber(RandomNumberGenerator lottoNumberGenerator) {
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

    @Override
    public LottoNumber clone() {
        try {
            return (LottoNumber) super.clone();
        } catch (CloneNotSupportedException ce) {
            throw new RuntimeException("로또 번호를 만드는데 문제가 있습니다.");
        }
    }
}
