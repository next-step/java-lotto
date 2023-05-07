package lotto.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public enum Win {

    WIN_3(3, 5000),
    WIN_4(4, 50_000),
    WIN_5(5, 1_500_000),
    WIN_6(6, 2_000_000_000);

    private int points;
    private int prize;

    Win(int points, int prize) {
        this.points = points;
        this.prize = prize;
    }

    public static Map<Win, Integer> convertToWinMap(Map<Integer, Integer> map) {
        Map<Win, Integer> winTotal = mapOf();
        map.forEach((key, value) -> putIfValid(winTotal, key, value));
        return winTotal;
    }

    private static void putIfValid(Map<Win, Integer> winTotal, Integer key, Integer value) {
        if (Win.isValidWinPoints(key)) {
            winTotal.put(Win.valueOf("WIN_" + key), value);
        }
    }

    private static Map<Win, Integer> mapOf() {
        Map<Win, Integer> winTotal = new EnumMap<>(Win.class);
        for (int i = 0; i < Win.values().length; i++) {
            winTotal.put(Win.values()[i], 0);
        }
        return winTotal;
    }

    public static boolean isValidWinPoints(int points) {
        return points >= 3 && points <= 6;
    }

    public static int totalMoney(Map<Win, Integer> winTotal) {
        int sum = 0;
        for (int i = 0; i < Win.values().length; i++) {
            sum += Win.values()[i].getPrize() * winTotal.get(Win.values()[i]);
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
