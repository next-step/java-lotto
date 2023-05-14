package lotto.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Win {
    DEFAULT(0, 0),
    WIN_3(3, 5000),
    WIN_4(4, 50_000),
    WIN_5(5, 1_500_000),
    WIN_6(6, 2_000_000_000);

    private final int points;
    private final int prize;
    private static final Map<Integer, Win> VALUE_MAP = Arrays.stream(Win.values()).collect(Collectors.toMap(Win::getPoints, Function.identity()));

    Win(int points, int prize) {
        this.points = points;
        this.prize = prize;
    }

    public static Win from(Integer winCount) {
        if (isValidWinPoints(winCount)) {
            return VALUE_MAP.get(winCount);
        }
        return Win.DEFAULT;
    }

    public static boolean isValidWinPoints(int points) {
        return points >= WIN_3.points && points <= WIN_6.points;
    }

    public static int totalMoney(Map<Win, Integer> winTotal) {
        int sum = 0;
        for (int i = 0; i < Win.values().length; i++) {
            sum += Win.values()[i].getPrize() * winTotal.getOrDefault(Win.values()[i], 0);
        }
        return sum;
    }

    public static String calculateProfitRate(int income, double outcome) {
        DecimalFormat df = new DecimalFormat("0.00");
        final double profit = income / outcome;
        df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(profit);
    }

    public int getPoints() {
        return points;
    }

    public int getPrize() {
        return prize;
    }
}
