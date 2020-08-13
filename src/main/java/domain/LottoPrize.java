package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoPrize {
    public static final int MIN_HIT_NUMBER = 3;
    private Map<Prize, Integer> prizes;

    public LottoPrize() {
        Map<Prize, Integer> prizes = new HashMap<>();
        for (Prize value : Prize.values()) {
            prizes.put(value, 0);
        }

        this.prizes = prizes;
    }

    public void win(int hitNumber) {
        if (hitNumber < MIN_HIT_NUMBER) {
            return;
        }

        Prize prize = Prize.of(hitNumber);
        prizes.put(prize, prizes.get(prize) + 1);
    }

    public Map<Prize, Integer> getPrizes() {
        return this.prizes;
    }

    public int getTotalPrizeMoney() {
        int result = 0;
        for (Map.Entry<Prize, Integer> entry : prizes.entrySet()) {
            result += entry.getKey().getMoney() * entry.getValue();
        }

        return result;
    }
}
