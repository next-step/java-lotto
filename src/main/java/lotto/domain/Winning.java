package lotto.domain;

import java.util.Map;

public class Winning {

    Map<Integer, Integer> winning;

    public Winning(Map<Integer, Integer> winning) {
        this.winning = winning;
    }

    public int getSumAmount() {
        int sum = 0;

        for (Integer integer : winning.keySet()) {
            sum += integer * winning.get(integer);
        }

        return sum;
    }
}
