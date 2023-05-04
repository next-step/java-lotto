package lotto.model;

import java.util.Map;

public enum Win {
    WIN_3(3, 5000),
    WIN_4(4, 50000),
    WIN_5(5, 1500000),
    WIN_6(6, 2000000000);

    private int points;
    private int prize;

    Win(int points, int prize) {
        this.points = points;
        this.prize = prize;
    }

    public static int totalMoney(Map<Win, Integer> winTotal) {
        int sum = 0;
        for (int i = 0; i < Win.values().length; i++) {
            sum += Win.values()[i].getPrize() * winTotal.get(Win.values()[i]);
        }
        return sum;
    }

    public int getPoints() {
        return points;
    }

    public int getPrize() {
        return prize;
    }
}
