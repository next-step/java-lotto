package lotto.domain;

import lotto.exceptions.InputFormatException;

import java.util.HashMap;
import java.util.Map;

public class LottoNo {
    private int number;
    private static Map<Integer, LottoNo> lottoNoMap = new HashMap<>();

    private LottoNo(int number) {
        this.number = number;
        if (!(this.number >= 1 && this.number <= 45)) {
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
