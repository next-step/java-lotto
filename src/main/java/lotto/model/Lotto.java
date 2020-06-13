package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public List<Integer> lottoDrawNumbers = new ArrayList();
    public static final int LIMIT = 6;

    public Lotto() {
        for(int i = 1; i <= 45; i++) {
            lottoDrawNumbers.add(i);
        }
    }
}
