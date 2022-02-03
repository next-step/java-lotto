package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Integer> numberList;

    public Numbers(final List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numberList);
    }
}
