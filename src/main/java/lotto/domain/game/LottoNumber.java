package lotto.domain.game;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-26.
 */
public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 45;

    public static final String MESSAGE_LOTTO_NUMBER_TYPE = "로또번호는 숫자형입니다.";
    public static final String MESSAGE_VALID_NUMBER = "로또 번호는 %d ~ %d 사이의 수로만 입력합니다.";

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(String before) {
        int lottoNumber = getNumber(before);

        return from(lottoNumber);
    }

    public static LottoNumber from(int lottoNumber) {
        checkRange(lottoNumber);

        return new LottoNumber(lottoNumber);
    }

    public int value() {
        return lottoNumber;
    }

    private static int getNumber(String before) {
        try {
            return Integer.valueOf(before);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_TYPE);
        }
    }

    private static void checkRange(int bonusBall) {
        if ( bonusBall < VALID_MIN_NUMBER || bonusBall > VALID_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(MESSAGE_VALID_NUMBER, VALID_MIN_NUMBER, VALID_MAX_NUMBER));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }
}
