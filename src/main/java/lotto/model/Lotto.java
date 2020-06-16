package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public List<Integer> lottoDrawNumbers = new ArrayList();
    public static final int LOTTO_PRICE = 1000;
    public static final int LIMIT = 6;
    private static final int MAX = 45;

    public Lotto() {
        for(int i = 1; i <= MAX; i++) {
            lottoDrawNumbers.add(i);
        }
    }
}
