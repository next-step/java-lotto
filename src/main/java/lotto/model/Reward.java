package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Reward {
    Blank(0, 0), THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), BONUS(5, 30_000_000), SIX(6, 2000000000);

    private int win;
    private int money;

    Reward(int win, int money) {
        this.money = money;
        this.win = win;
    }

    public static Reward of(int win, boolean isBonus) {
        if (isBonus) {
            return BONUS;
        }
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.win == win)
                .findFirst()
                .orElse(Blank);
    }

    public static String toPayload(Map<Reward, Integer> matches) {
        StringBuilder payload = new StringBuilder("");
        for (Reward reward : Arrays.stream(Reward.values()).filter(reward -> reward != Blank).collect(Collectors.toList())) {
            String sentence = "₩" + reward.money;
            payload.append(reward.toString() + " matches (" + sentence + "): " + matches.get(reward) + "\n");
        }
        return payload.toString();
    }

    public int calculateEarnedMoney(Integer win) {
        return this.money * win;
    }

    public boolean hasEqualMoney(int expected) {
        return this.money == expected;
    }
};


