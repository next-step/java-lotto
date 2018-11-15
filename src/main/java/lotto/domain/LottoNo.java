package lotto.domain;


import java.util.HashMap;
import java.util.Map;

import static lotto.utils.Utils.LOTTO_NUMBER_RANGE_END;
import static lotto.utils.Utils.LOTTO_NUMBER_RANGE_START;

public class LottoNo implements Comparable<LottoNo> {
    private int number;

    private static final Map<Integer, LottoNo> reusableLottoNo = new HashMap<>();

    public LottoNo(int number) {
        this.number = number;
        if(isInvalidRange())
            throw new IllegalArgumentException();
    }

    public static LottoNo getInstance(int no) {
        if(!reusableLottoNo.containsKey(no)) {
            LottoNo lottoNo = new LottoNo(no);
            reusableLottoNo.put(no, lottoNo);
        }

        return reusableLottoNo.get(no);
    }

    public boolean isInvalidRange() {
        return this.number < LOTTO_NUMBER_RANGE_START || this.number > LOTTO_NUMBER_RANGE_END;
    }

    @Override
    public int compareTo(LottoNo o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return this.number + "";
    }
}
