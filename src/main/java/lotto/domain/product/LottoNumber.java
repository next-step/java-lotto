package lotto.domain.product;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final Random RANDOM = new Random();
    private final Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public static LottoNumber makeRandomNumber() {
        return new LottoNumber(RANDOM.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
    }

    public Integer getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
