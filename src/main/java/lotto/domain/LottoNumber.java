package lotto.domain;

import java.util.*;

public class LottoNumber {
    static final int LOTTO_START_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = LOTTO_START_NUMBER; i < LOTTO_END_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNumbers.get(number))
                .orElseThrow(() -> new IllegalArgumentException(String
                        .format("%d는 1~45 숫자 사이의 번호가 아닙니다", number)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
