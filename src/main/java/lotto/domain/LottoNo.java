package lotto.domain;


import static lotto.utils.Utils.LOTTO_NUMBER_RANGE_END;
import static lotto.utils.Utils.LOTTO_NUMBER_RANGE_START;

public class LottoNo implements Comparable<LottoNo> {
    private int number;

    public LottoNo(int number) {
        this.number = number;
    }

    public boolean isInvalidRange() {
        return this.number < LOTTO_NUMBER_RANGE_START || this.number >LOTTO_NUMBER_RANGE_END;
    }

    @Override
    public int compareTo(LottoNo o) {
        return this.number - o.number;
    }
}
