package lotto.domain;

import lotto.exceptions.InputFormatException;

import java.util.HashMap;
import java.util.Map;

public class LottoNo {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static Map<Integer, LottoNo> lottoNoMap = new HashMap<>();
    private int number;

    private LottoNo(int number) {
        this.number = number;
        if (!(this.number >= MINIMUM_LOTTO_NUMBER && this.number <= MAXIMUM_LOTTO_NUMBER)) {
            throw new InputFormatException();
        }
    }

    public int getLottoNumber() {
        return this.number;
    }

    public static LottoNo lottoNoFactory(int number) {
        if (lottoNoMap.get(number) == null) {
            lottoNoMap.put(number, new LottoNo(number));
        }
        return lottoNoMap.get(number);
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == (Integer)obj;
    }
}
