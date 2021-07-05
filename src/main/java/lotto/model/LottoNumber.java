package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> NUMBERS = new HashMap<>();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private int number;

    @Override
    public String toString() {
        return number + "";
    }

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            NUMBERS.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(int number) {
        checkNumber(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return NUMBERS.get(number);
    }

    private void checkNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("당첨번호는 1부터 45까지의 숫자입니다.");
        }
    }

    public boolean isSame(LottoNumber lottoNumber) {
        if (number == lottoNumber.getNumber()) {
            return true;
        }
        return false;
    }

    public int getNumber() {
        return number;
    }
}
