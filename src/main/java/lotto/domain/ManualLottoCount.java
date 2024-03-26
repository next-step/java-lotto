package lotto.domain;

import java.util.Collections;
import java.util.Iterator;

public class ManualLottoCount {
    private final Integer count;

    public ManualLottoCount(Integer count) {
        validateIfNotNull(count);
        this.count = count;
    }

    public void validateIfLargerThanWholeCount(Cash cash){
        int amount = cash.getAmount();
        if(amount < this.count) throw new IllegalArgumentException();
    }

    private void validateIfNotNull(Integer count){
        if(count == null){
            throw new IllegalArgumentException();
        }
    }

    public Iterator<Integer> iterator() {
        return Collections.singleton(this.count).iterator();
    }
}
