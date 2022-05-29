package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryGame {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final List<Integer> LOTTO_LIST = new ArrayList<>() {{
        for (int i = START_NUMBER; i < END_NUMBER; i++) {
            add(i);
        }
    }};

    private List<Integer> lotteries;

    public LotteryGame(List<Integer> lotteries) {
        this.lotteries = lotteries;
    }

    public static LotteryGame create() {
        Collections.shuffle(LOTTO_LIST);
        List<Integer> subList = new ArrayList<>(LOTTO_LIST.subList(0, 6));
        Collections.sort(subList);
        return new LotteryGame(Collections.unmodifiableList(subList));
    }

    public boolean isContain(int number) {
        return this.lotteries.contains(number);
    }

    @Override
    public String toString() {
        return String.valueOf(lotteries);
    }
}
