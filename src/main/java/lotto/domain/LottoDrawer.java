package lotto.domain;

import lotto.view.Prize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoDrawer {
    private LottoDrawer() {
    }

    public static double calProfit(Money price, List<Integer> hitNumbers) {
        return price
                .profit(totalPrize(hitNumbers))
                .doubleValue();
    }

    public static List<Integer> hitNumber(List<Lotto> lottos, Lotto wonNumber) {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCount.add(lotto.matchedNumber(wonNumber));
        }
        return matchCount;
    }

    public static BigDecimal totalPrize(List<Integer> hitNumbers) {
        BigDecimal totalPrize = BigDecimal.ZERO;

        for (Integer i : hitNumbers) {
            totalPrize = totalPrize.add(BigDecimal.valueOf(Prize.calculatePrize(i)));
        }
        return totalPrize;
    }
}
