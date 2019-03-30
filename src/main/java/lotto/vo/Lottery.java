package lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    public static final int INITIAL_NUMBER = 0;
    public static final int ADD_NUMBER = 1;
    private final Set<Integer> lotto;

    public Lottery(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lottery toLotteries(List<Integer> lotteryNumbers) {
        Set<Integer> lotto = new HashSet<>();
        for (Integer number : lotteryNumbers) {
            lotto.add(number);
        }
        return new Lottery(lotto);
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    public int containsCount(Lottery userLotto) {
        int count = INITIAL_NUMBER;
        for (Integer number : userLotto.lotto) {
            if (lotto.contains(number)) {
                count += ADD_NUMBER;
            }
        }
        return count;
    }
}
