package Lotto.domain;

import static Lotto.domain.Lottos.LOTTO_MAX_NUMBER;
import static Lotto.domain.Lottos.LOTTO_MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    "입력된 번호: " + number + "는 적절하지 않습니다." +
                            LOTTO_MIN_NUMBER + " ~ " + LOTTO_MAX_NUMBER + "사이의 값을 입력해 주세요."
            );
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean isInvalidLottoNumber(String input) {
        if(input == null || input.trim().isEmpty()) {
            return true;
        }

        if(!input.chars().allMatch(Character::isDigit)) {
            return true;
        }

        if(Integer.parseInt(input) < LOTTO_MIN_NUMBER || Integer.parseInt(input)  > LOTTO_MAX_NUMBER) {
            return true;
        }

        return false;
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
        return Integer.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
