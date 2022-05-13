package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Reward {
    Blank(0, new Money(0)), THREE(3, new Money(5000)), FOUR(4, new Money(50000)), FIVE(5, new Money(1500000)), BONUS(5, new Money(30_000_000)), SIX(6, new Money(2000000000));

    private int win;
    private Money money;

    Reward(int win, Money money) {
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
            String sentence = reward.money.toPayload();
            payload.append(reward.toString() + " matches (" + sentence + "): " + matches.get(reward) + "\n");
        }
        return payload.toString();
    }

    public Money getMoney() {
        return this.money;
    }

    public int calc(Integer win) {
        return this.money.calc(win);
    }
};


