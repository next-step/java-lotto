package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;
    private static final List<LottoNumber> CACHE = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            CACHE.add(new LottoNumber(i));
        }
    }

    private LottoNumber(int input) {
        try {
            validate(input);
        } catch (Exception e) {
            throw e;
        }

        number = input;
    }

    private LottoNumber(String strInput) {
        int input = LottoUtil.stringToInt(strInput);
        try {
            validate(input);
        } catch (Exception e) {
            throw e;
        }

        number = input;
    }

    public static LottoNumber valueOf(int i) {
        validate(i);
        LottoNumber lottoNumber = CACHE.get(i - 1);
        if (Objects.isNull(lottoNumber)) {
            lottoNumber = new LottoNumber(i);
        }
        return lottoNumber;
    }

    public static LottoNumber valueOf(String input) {
        int i = LottoUtil.stringToInt(input);
        return valueOf(i);
    }

    public int getNumber() {
        return number;
    }

    private static void validate(int input) {
        if (input < MIN_NUMBER)
            throw new IllegalArgumentException(String.format("Lotto 숫자는 %d보다 커야 합니다.", MIN_NUMBER));

        if (input > MAX_NUMBER)
            throw new IllegalArgumentException(String.format("Lotto 숫자는 %d보다 작아야 합니다.", MAX_NUMBER));
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object object) {
        LottoNumber lottoNumber = (LottoNumber) object;
        if (this.getNumber() == lottoNumber.getNumber()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
