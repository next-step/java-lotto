package step2.domain;

import step2.exception.InvalidLottoNumberException;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final List<LottoNumber> ALL_NUMBERS = defaultNumbers();

    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER) {
            throw new InvalidLottoNumberException();
        }
    }

    private static List<LottoNumber> defaultNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public static List<LottoNumber> allLottoNumbers() {
        return ALL_NUMBERS;
    }

    public int number() {
        return number;
    }

}
