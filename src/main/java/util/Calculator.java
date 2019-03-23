package util;

import domain.LottoRank;

import java.util.Arrays;
import java.util.Map;

public class Calculator {

    public static double yieldCalculator(Map<LottoRank, Integer> produceResult, int investment) {
        int revenue = Arrays.stream(LottoRank.values())
                            .mapToInt(lottoRank -> lottoRank.calculatePrize(nullToZero(produceResult.get(lottoRank))))
                            .sum();

        return (double) revenue / investment;
    }

    public static int nullToZero(Integer number) {
        return number == null ? 0 : number;
    }
}
