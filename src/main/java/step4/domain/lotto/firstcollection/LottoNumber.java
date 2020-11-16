package step4.domain.lotto.firstcollection;

import step4.Constant;

import java.util.Objects;

import static step3.Constant.ERROR_OUT_RANGE_NUMBER;

public class LottoNumber {
    public static final int MINIMUM_ANCHOR_POINT = 0;
    public static final int MAXIMUM_ANCHOR_POINT = 45;

    private final int number;

    public LottoNumber(int number) {
        isValid(number);
        this.number = number;
    }

    public LottoNumber(String numberStr) {
        this.number = toNumeric(numberStr);
    }

    private int toNumeric(String numberStr) {
        try{
            int parsedInt = Integer.parseInt(numberStr.trim());
            isValid(parsedInt);
            return parsedInt;
        }catch(NumberFormatException error){
            throw new NumberFormatException(Constant.ERROR_REQUIRED_NUMERIC);
        }
    }

    private void isValid(int number) {
        if (number <= MINIMUM_ANCHOR_POINT || number > MAXIMUM_ANCHOR_POINT) {
            throw new IllegalArgumentException(ERROR_OUT_RANGE_NUMBER);
        }
    }

    public String getString() {
        return String.valueOf(number);
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
}
