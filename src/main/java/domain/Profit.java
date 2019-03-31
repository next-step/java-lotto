package domain;

import util.Calculator;

import java.util.Arrays;

public class Profit {
    private static final int THOUSAND_UNITS = 1000;
    private double revenue;

    public Profit(LottoResult lottoResult) {
        this.revenue = Arrays.stream(LottoRank.values())
                .mapToInt(lottoRank -> lottoRank.calculatePrize(Calculator.nullToZero(lottoResult.lottoMatchCount(lottoRank))))
                .sum();
    }

    public double calcProfile(int lottoPaper) {
        return this.revenue / (lottoPaper * THOUSAND_UNITS);
    }
}
