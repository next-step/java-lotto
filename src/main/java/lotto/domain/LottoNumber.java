package lotto.domain;

import exception.CustomException;
import lotto.exception.LottoErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    public static final int MINIMUM_VALUE = 1;
    public static final int MAXIMUM_VALUE = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS_RANGE;
    
    private final Integer number;

    private LottoNumber(String value) {
        int number = Integer.parseInt(value);
        checkLottoNumber(number);
        this.number = number;
    }

    private LottoNumber(int number) {
        checkLottoNumber(number);
        this.number = number;
    }

    private void checkLottoNumber(Integer number) {
        if (!isValidLottoNumber(number)) {
            throw new CustomException(LottoErrorCode.LOTTO_NUMBER_BAD_REQUEST);
        }
    }

    private boolean isValidLottoNumber(Integer number) {
        return number >= MINIMUM_VALUE && number <= MAXIMUM_VALUE;
    }

    public static List<LottoNumber> from(String[] stringLottoNumbers) {
        List<LottoNumber> result = new ArrayList<>();
        for (String number : stringLottoNumbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            result.add(lottoNumber);
        }
        return result;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber from(LottoNumber lottoNumber) {
        return new LottoNumber(lottoNumber.number);
    }

    static {
        LOTTO_NUMBERS_RANGE = new ArrayList<>();
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {
            LOTTO_NUMBERS_RANGE.add(new LottoNumber(i));
        }
    }

    public static List<LottoNumber> getLottoNumbersRange() {
        List<LottoNumber> result = new ArrayList<>();
        for (LottoNumber lottoNumber : LOTTO_NUMBERS_RANGE) {
            result.add(new LottoNumber(lottoNumber.number));
        }
        return result;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
