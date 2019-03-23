package domain;

import application.LottoGameResult;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static application.LottoGameResult.multiple;

public class LottoCalculator implements Calculator {
    public double run(List<Integer> score, int price) {
        return format(divide(sum(score), price));
    }

    public static int sum(List<Integer> scores) {
        return Arrays.stream(LottoGameResult.values())
                .mapToInt(v -> multiple(v.getValue(), scores.get(v.getValue())))
                .sum();
    }

    private static double format(double number) {
        return Double.valueOf(new DecimalFormat("#.##").format(number));
    }

    private static double divide(int profit, int price) {
        return (profit / (double) price);
    }

}
