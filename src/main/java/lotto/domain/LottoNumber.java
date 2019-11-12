package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static lotto.domain.NumberGenerator.LOTTO_END_NUM;
import static lotto.domain.NumberGenerator.LOTTO_START_NUM;

public class LottoNumber {

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
}
