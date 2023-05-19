package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_MAXIMUM_VALUE = 45;
    private static final int LOTTO_MINIMUM_VALUE = 1;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int number;

    static {
        for (int i = LOTTO_MINIMUM_VALUE; i <= LOTTO_MAXIMUM_VALUE; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    public static LottoNumber of(String number) {
        return of(convertToNumber(number));
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (Objects.isNull(lottoNumber)) {
            throw new IllegalArgumentException("로또숫자는 1 ~ 45 사이의 숫자여야 합니다. 에러 숫자 > " + number);
        }
        return lottoNumber;
    }

    private static int convertToNumber(String number) {
        int result = 0;
        try {
            result = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("로또 번호는 숫자형태만 가능합니다. " + number + "는 숫자 형태가 아닙니다.");
        }
        return result;
    }

    private void checkNumberRange(int number) {
        if (number < LOTTO_MINIMUM_VALUE || number > LOTTO_MAXIMUM_VALUE) {
            throw new IllegalArgumentException("로또숫자는 1 ~ 45 사이의 숫자여야 합니다. 에러 숫자 : " + number);
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
        return number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
