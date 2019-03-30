package util;

import domain.LottoRank;

import java.util.Arrays;
import java.util.Map;

public class Calculator {
    private static final int THOUSAND_UNITS = 1000;

    public static double yieldCalculator(Map<LottoRank, Integer> produceResult, int lottoPaper) {
        int revenue = Arrays.stream(LottoRank.values())
                            .mapToInt(lottoRank -> lottoRank.calculatePrize(nullToZero(produceResult.get(lottoRank))))
                            .sum();

        return (double) revenue / (lottoPaper * THOUSAND_UNITS);
    }

    public static int nullToZero(Integer number) {
        return number == null ? 0 : number;
    }
}
