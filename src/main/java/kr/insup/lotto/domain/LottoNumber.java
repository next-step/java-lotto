package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoNumber {
    private Integer number;
    private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();


    static {
        for (int i = LottoConfig.MIN_NUMBER; i <= LottoConfig.MAX_NUMBER; i++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        return Optional.ofNullable(lottoNumberMap.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer number() {
        return number;
    }
}
