package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {

    static final int LOTTO_START_NUM = 1;
    static final int LOTTO_END_NUM = 45;

    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private int lottoNumber;

    private LottoNumber(int number) {
        if (number < LOTTO_START_NUM || number > LOTTO_END_NUM) {
            throw new RuntimeException();
        }

        this.lottoNumber = number;
    }

    static LottoNumber of(String value) {
        return Optional.ofNullable(value)
                .map(String -> of(Integer.parseInt(value.trim())))
                .orElseThrow(RuntimeException::new);
    }

    static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNumbers.get(number))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String toString() {
        return "{" + lottoNumber + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
