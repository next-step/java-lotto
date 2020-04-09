package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNumbers.get(number))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1부터 45까지만 가능합니다."));
    }

    static LottoNumber of(String number) {
        return Optional.ofNullable(lottoNumbers.get(Integer.parseInt(number)))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1부터 45까지만 가능합니다."));
    }
}
