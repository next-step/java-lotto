package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoInfo {
    public static final int PRICE = 1000;
    public static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            NUMBERS.add(i);
        }
    }
}
