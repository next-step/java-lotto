package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lotto.utils.ValidationUtil;

public class LottoNumber implements Comparable {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    private final int number;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int number) {
        validateOutOfRange(number);
        this.number = number;
    }

    public LottoNumber(String numberText) {
        if (!ValidationUtil.isIntegerNumber(numberText)) {
            throw new IllegalArgumentException("로또번호는 숫자만 입력 가능합니다.");
        }
        this.number = Integer.parseInt(numberText);
        validateOutOfRange(this.number);
    }

    public static LottoNumber of(String numberText) {
        if (!ValidationUtil.isIntegerNumber(numberText)) {
            throw new IllegalArgumentException("로또번호는 숫자만 입력 가능합니다.");
        }
        return of(Integer.parseInt(numberText));
    }

    public static LottoNumber of(int number) {
        validateOutOfRange(number);
        return lottoNumbers.get(number);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Object o) {
        return this.number - ((LottoNumber)o).getNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    private static void validateOutOfRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}
