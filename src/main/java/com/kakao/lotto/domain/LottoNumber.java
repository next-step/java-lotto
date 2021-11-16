package com.kakao.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private final int value;
    private static final List<LottoNumber> baseLotto = createBaseLottoNumber();

    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int lottoNumber) {
        validate(lottoNumber);
        return baseLotto.get(lottoNumber - 1);
    }

    private static void validate(int input) {
        if (input < LOTTO_MIN || input > LOTTO_MAX) {
            throw new IllegalArgumentException(input + "은 로또 번호에 포함되지 않습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    private static List<LottoNumber> createBaseLottoNumber() {
        return IntStream.range(LOTTO_MIN, LOTTO_MAX + 1)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
