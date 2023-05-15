package lotto.domain;

import lotto.view.Prize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoDrawer {
    public static double calProfit(Money price, List<Integer> hitNumber) {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (Integer i : hitNumber) {
            totalPrize = totalPrize.add(BigDecimal.valueOf(Prize.calculatePrize(i)));
        }
        BigDecimal decimalPrice = BigDecimal.valueOf(price.getMoney());
        BigDecimal profit = BigDecimal.ONE.add(totalPrize.subtract(decimalPrice).divide(decimalPrice, 2, BigDecimal.ROUND_FLOOR));
        return profit.doubleValue();
    }

    public static List<Integer> hitNumber(List<Lotto> lottos, Lotto wonNumber) {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCount.add(lotto.matchedNumber(wonNumber));
        }
        return matchCount;
    }
}
