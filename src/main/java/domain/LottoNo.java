package domain;

import util.Generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoNo {
    private static final Map<Integer, LottoNo> LOTTO_NOS = new HashMap<>();

    static {
        for (int i = Generator.MIN_LOTTO_NUMBER; i <= Generator.MAX_LOTTO_NUMBER; i++) {
            LOTTO_NOS.put(i, new LottoNo(i));
        }
    }

    private final int LOTTO_NO;

    private LottoNo(int lottoNo) {
        if (lottoNo < Generator.MIN_LOTTO_NUMBER || lottoNo > Generator.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 범위를 벗어났습니다.");
        }
        this.LOTTO_NO = lottoNo;
    }

    public static LottoNo of(int lottoNo) {
        return Optional.ofNullable(LOTTO_NOS.get(lottoNo))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return String.valueOf(this.LOTTO_NO);
    }

}
