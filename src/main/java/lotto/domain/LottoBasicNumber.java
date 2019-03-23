package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBasicNumber {

    public static final List<Integer> basicNumbers;

    static {
        basicNumbers = new ArrayList<>();
        for (int i = 1; i < 45; i++) {
            basicNumbers.add(i);
        }
    }
}
