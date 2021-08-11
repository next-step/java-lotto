package lotto.util;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.List;

public class LottoNumberUtil {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    public static int getLottoStartNumber() {
        return START_NUMBER;
    }

    public static int getLottoEndNumber() {
        return END_NUMBER;
    }

    public static boolean validNumber(int number) {
        if (number >= START_NUMBER && number <= END_NUMBER) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public static boolean containsNumber(List<LottoNumber> numbers, LottoNumber number) {
        if (numbers == null || numbers.size() < 1 || !numbers.contains(number)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
