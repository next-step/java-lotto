package nextstep.lotto.dto;

import java.util.Objects;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_LOTTO_NUMBER_RANGE;
import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_ONLY_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private LottoNumber(int number) {
        this.number = number;

        if(this.number < LOTTO_NUMBER_MIN || this.number > LOTTO_NUMBER_MAX){
            throw new RuntimeException(INVALID_INPUT_LOTTO_NUMBER_RANGE);
        }
    }

    public static LottoNumber create(int number){
        return new LottoNumber(number);
    }

    public static LottoNumber createByString(String inputNumber){
        int number = 0;
        try {
            number = Integer.parseInt(inputNumber);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException (INVALID_INPUT_ONLY_NUMBER);
        }
        return new LottoNumber(number);
    }

    public int getNumber() {
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
    public int compareTo(LottoNumber lottoNumber) {
        if(this.number > lottoNumber.number) {
            return 1;
        }
        return (this.number == lottoNumber.number) ? 0 : -1;
    }
}
