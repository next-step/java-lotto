package lotto.domain.product;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final Random RANDOM = new Random();
    private final Integer number;

    private static final LottoNumber[] CACHE = new LottoNumber[MAX_LOTTO_NUMBER];

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            CACHE[i - 1] = new LottoNumber(i);
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number));
    }

    public static LottoNumber of(Integer number) {
        validateInput(number);
        return CACHE[number - 1];
    }

    private static void validateInput(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Invalid number: " + number);
        }
    }

    public static LottoNumber makeRandomNumber() {
        return of(RANDOM.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
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
