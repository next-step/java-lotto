package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Statistics {
    private static final HashMap<Integer, Integer> AGREEMENT = new HashMap<>();
    private static final int THREE_AGREEMENT = 5000;
    private static final int FOUR_AGREEMENT = 50000;
    private static final int FIVE_AGREEMENT = 1500000;
    private static final int SIX_AGREEMENT = 2000000000;
    private static final List<Integer> PRIZE = List.of(THREE_AGREEMENT, FOUR_AGREEMENT, FIVE_AGREEMENT, SIX_AGREEMENT);

    public HashMap<Integer, Integer> setUp() {
        AGREEMENT.put(THREE_AGREEMENT, 0);
        AGREEMENT.put(FOUR_AGREEMENT, 0);
        AGREEMENT.put(FIVE_AGREEMENT, 0);
        AGREEMENT.put(SIX_AGREEMENT, 0);

        return AGREEMENT;
    }

    public HashMap<Integer, Integer> save(List<List<Integer>> lottoList, int[] winNumbers) {
        for (int i = 0; i < lottoList.size(); i++) {
            countUp(match(lottoList.get(i), winNumbers));
        }
        return AGREEMENT;
    }

    private void countUp(int count) {
        if (count == 3) {
            AGREEMENT.put(THREE_AGREEMENT, AGREEMENT.get(THREE_AGREEMENT) + 1);
        }
        if (count == 4) {
            AGREEMENT.put(FOUR_AGREEMENT, AGREEMENT.get(FOUR_AGREEMENT) + 1);
        }
        if (count == 5) {
            AGREEMENT.put(FIVE_AGREEMENT, AGREEMENT.get(FIVE_AGREEMENT) + 1);
        }
        if (count == 6) {
            AGREEMENT.put(SIX_AGREEMENT, AGREEMENT.get(SIX_AGREEMENT) + 1);
        }
    }


    public int match(List<Integer> value, int[] winNumbers) {
        int count = 0;
        for (int i = 0; i < value.size(); i++) {
            count += isContain(value, winNumbers[i]);
        }
        return count;
    }

    private int isContain(List<Integer> value, int winNumber) {
        if (value.contains(winNumber)) {
            return 1;
        }
        return 0;
    }

    public double revenue(int purchase) {
        double total = 0;
        int prize;

        for (int i = 0; i < PRIZE.size(); i++) {
            prize = PRIZE.get(i);
            total += prize * AGREEMENT.get(prize);
        }

        return total / purchase;
    }
}
