package lotto;

import java.util.Map;

public enum Reward {
    Blank(0, new Money(0)),
    THREE(3, new Money(5000)),
    FOUR(4, new Money(50000)),
    FIVE(5, new Money(1500000)),
    SIX(6, new Money(2000000000));

    private int win;
    private Money money;

    Reward(int win, Money money) {
        this.money = money;
        this.win = win;
    }

    public static Reward of(int win) {
        for (Reward reward : Reward.values()) {
            if (reward.win == win) {
                return reward;
            }
        }
        return Blank;
    }

    public static String toPayload(Map<Integer, Integer> matches)
    {
        StringBuilder payload = new StringBuilder("");
        for (int key : matches.keySet()) {
            String sentence = Reward.of(key).money.toPayload();
            payload.append(key + " matches ("+ sentence + "): " + matches.get(key) + "\n");
        }
        return payload.toString();
    }

    public Money getMoney(){
        return this.money;
    }
};


