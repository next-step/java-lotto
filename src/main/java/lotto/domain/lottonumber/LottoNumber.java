package lotto.domain.lottonumber;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

    private final int number;
    private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    public static final int LOTTONUMBER_MINIMUM = 1;
    public static final int LOTTONUMBER_MAXIMUM = 45;
    private static final String LOTTONUMBER_BOUND_EXCEPTION = "로또 번호는 " + LOTTONUMBER_MINIMUM + "부터 " + LOTTONUMBER_MAXIMUM + "까지입니다.";

    static {
        IntStream.range(LOTTONUMBER_MINIMUM, LOTTONUMBER_MAXIMUM)
                .mapToObj(number -> new LottoNumber(number))
                .forEach(lottoNumber -> lottoNumberMap.put(lottoNumber.number(), lottoNumber));
    }

    private LottoNumber(final int number) {
        checkNumber(number);
        this.number = number;
    }

    private static boolean checkLottoNumberBound(int number) {
        return number < LOTTONUMBER_MINIMUM || number > LOTTONUMBER_MAXIMUM;
    }

    public static LottoNumber get(int number) {
        checkNumber(number);
        return lottoNumberMap.get(number);
    }

    private static void checkNumber(int number) {
        if (checkLottoNumberBound(number)) {
            throw new IllegalArgumentException(LOTTONUMBER_BOUND_EXCEPTION);
        }
    }

    public int number() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
