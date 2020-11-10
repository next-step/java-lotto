package lotto.domain.lotto;

import lotto.domain.exception.InvalidRangeLottoNumbersException;

public class LottoNumber {
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumbersRange(number);
        return new LottoNumber(number);
    }

    private static void validateNumbersRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidRangeLottoNumbersException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        return number == ((LottoNumber) o).number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public int getNumber() {
        return number;
    }
}
