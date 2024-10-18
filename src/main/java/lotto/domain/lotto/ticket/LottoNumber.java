package lotto.domain.lotto.ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private static final  int LOTTO_NUMBER_MIN = 1;
    private static final  int LOTTO_NUMBER_MAX = 45;
    private static final String LOTTO_NUMBER_ERROR = "로또번호는 숫자만 입력해주세요.";
    private static final String LOTTO_NUMBER_RANGE_ERROR = "1에서 45사이의 숫자만 입력해주세요.";
    private final int number;

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = validate(parseInt(number));
    }

    public static LottoNumber of(int number) {
        return lottoNumbers.get(number);
    }

    public static LottoNumber of(String number) {
        return lottoNumbers.get(validate(parseInt(number)));
    }

    public int getNumber() {
        return number;
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new NumberFormatException(LOTTO_NUMBER_ERROR);
        }
    }

    private static int validate(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
