package util;

import lotto.domain.Lottery;
import lotto.domain.LotteryNo;

import java.util.*;

public class Random {
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int LOTTO_LENGTH = 6;


    public Lottery generateRandom() {
        List<LotteryNo> random = makeNumber();

        Collections.shuffle(random);

        return new Lottery(new HashSet<>(random.subList(0, LOTTO_LENGTH)));
    }

    public List<LotteryNo> makeNumber() {
        List<LotteryNo> random = new ArrayList<>();

        for (int i = 1; i <= LOTTO_MAX_VALUE; i++) {
            random.add(new LotteryNo(i));
        }

        return random;
    }
}
