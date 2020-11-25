package lotto;

import java.util.*;

public class Lotto {

    private static final List<Integer> lottoTotalNumbers = new ArrayList<>();
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_SIZE = 6;

    static {
        for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
            lottoTotalNumbers.add(i);
        }
    }

    public Set<Integer> createAuto() {
        Collections.shuffle(lottoTotalNumbers);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            set.add(lottoTotalNumbers.get(i));
        }

        System.out.println("set = " + set.toString());
        return set;
    }
}
