package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoBox {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static List<LottoNumber> defaultNumbers = new ArrayList<>();

    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            defaultNumbers.add(new LottoNumber(i));
        }
    }

    public static List<LottoNumber> generateNumbers() {
        Collections.shuffle(defaultNumbers, new Random(System.currentTimeMillis()));
        return new ArrayList<>(defaultNumbers.subList(0, 6));
    }
}
