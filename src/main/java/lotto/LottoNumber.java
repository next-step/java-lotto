package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

    static final int LOTTO_MIN_NUM = 1;
    static final int LOTTO_MAX_NUM = 45;

    public static final Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
            .boxed()
            .collect(HashMap::new, (map, number) -> map.put(number, new LottoNumber(number)), HashMap::putAll);

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    private static void validateLottoNumber(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("로또 번호는 null일 수 없습니다.");
        }
        if (number < LOTTO_MIN_NUM || number > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static LottoNumber of(Integer number) {
        validateLottoNumber(number);
        return lottoNumberMap.get(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
