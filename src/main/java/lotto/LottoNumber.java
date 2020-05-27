package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private static final List<Integer> defaultLottoNumbers;

    static {
        defaultLottoNumbers = IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getDefaultLottoNumbers() {
        return defaultLottoNumbers;
    }

    public static boolean isValidNumber(int number) {
        if(number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX) {
            return true;
        }
        return false;
    }
}
