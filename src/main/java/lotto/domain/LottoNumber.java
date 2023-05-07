package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER + 1)
                .forEach(e -> lottoNumberCache.put(e, new LottoNumber(e)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return lottoNumberCache.get(number);
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("범위에 맞지 않는 수입니다. 입력한 수: %d", number));
        }
    }

    public int getNumber() {
        return number;
    }
}
