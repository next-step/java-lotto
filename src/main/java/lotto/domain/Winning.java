package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winning {

    Map<Integer, Integer> winning = new HashMap<>();

    public Winning() {
        winning.put(3, 0);
        winning.put(4, 0);
        winning.put(5, 0);
        winning.put(6, 0);
    }

    public Map<Integer, Integer> getWinning() {
        return winning;
    }

    public void record(int matchNumbers) {
        for (Integer integer : winning.keySet()) {
            if (integer == matchNumbers) {
                winning.put(matchNumbers, winning.get(integer) + 1);
            }
        }
    }

    public int getSumAmount() {
        int sum = 0;

        for (Integer integer : winning.keySet()) {
            sum += Amount.getWinningMoney(integer) * winning.get(integer);
        }

        return sum;
    }
}
