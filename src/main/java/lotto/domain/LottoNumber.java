package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final String IS_NOT_LOTTO_NUMBER = "로또번호가 1~45가 아닙니다.";
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    static {
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            cache.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static List<Integer> generateAutoLottoNumbers(int requestSize) {
        List<LottoNumber> numbers = new ArrayList<>(cache.values());
        Collections.shuffle(numbers);
        return numbers.subList(0, requestSize).stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public static LottoNumber of(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUM || lottoNumber > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
        }
        return cache.get(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
