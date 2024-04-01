package lotto.domain;

import java.util.Collections;
import java.util.Iterator;

public class ManualLottoCount{
    private final Integer count;

    public ManualLottoCount(Integer count) {
        validateIfNotNull(count);
        this.count = count;
    }

    public void validateIfLargerThanWholeCount(Cash cash) {
        int amount = cash.getAmount();
        if (amount < this.count) {
            throw new IllegalArgumentException("수동으로 입력한 로또의 개수는 전체 로또 개수를 초과할 수 없습니다.");
        }
    }

    private void validateIfNotNull(Integer count) {
        if (count == null) {
            throw new IllegalArgumentException("수동으로 입력한 로또 개수는 null이 아니어야 합니다.");
        }
    }

    public int getLeftOvers(Cash cash) {
        return cash.minus(this.count);
    }

    public Integer getCount() {
        return count;
    }

    public boolean isLargerThan(Integer count) {
        return this.count > count;
    }
}
