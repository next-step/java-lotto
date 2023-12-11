package domain;

import util.LottoNumberGenerator;

import java.util.Objects;

import static util.LottoNumberGenerator.MAX_LOTTO_NUMBER;
import static util.LottoNumberGenerator.MIN_LOTTO_NUMBER;

public class LottoNumber {
    private final int number;

    public static LottoNumber from(String input) {
        int num = Integer.parseInt(input.trim());
        return LottoNumber.valueOf(num);
    }

    public static LottoNumber valueOf(int num) {
        LottoNumber lottoNumber = LottoNumberGenerator.getNumber(num);
        validateNumberNull(lottoNumber);
        return lottoNumber;
    }

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.number = lottoNumber;
    }

    private static void validateNumberNull(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 숫자는 null값을 가질 수 없습니다.");
        }
    }

    private static void validateNumberRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d과 %d 사이만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    public int getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
