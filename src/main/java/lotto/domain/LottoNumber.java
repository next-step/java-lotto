package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 01:37
 */
public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER = new HashMap<>();

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBER.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;


    private LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER && number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45의 숫자만 가능합니다.");
        }
        this.lottoNumber = number;
    }

    static LottoNumber of(int number) {
        return Optional.ofNullable(LOTTO_NUMBER.get(number))
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 번호입니다."));
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
