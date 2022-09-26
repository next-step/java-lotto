package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1 이상이어야 합니다.";

    public static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int num = MIN; num <= MAX; num++) {
            LOTTO_NUMBERS.add(new LottoNumber(num));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LottoNumber)) {
            return false;
        }

        LottoNumber lottoNumber = (LottoNumber) o;
        return this.number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
