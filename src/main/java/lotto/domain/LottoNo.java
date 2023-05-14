package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNo implements Comparable<LottoNo> {
    private final int number;
    private static final Map<Integer, LottoNo> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.put(i, new LottoNo(i));
        }
    }

    private LottoNo(int number) {
        this.number = number;
    }

    public static LottoNo of(int number) {
        if (!lottoNumbers.containsKey(number)) {
            lottoNumbers.put(number, new LottoNo(number));
        }
        return lottoNumbers.get(number);
    }

    public int getValue() {
        return number;
    }

    @Override
    public int compareTo(LottoNo o) {
        return Integer.compare(this.number, o.number);
    }
}
