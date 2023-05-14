package lotto.domain;

import lotto.view.Prize;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoDrawer {
    public static double calProfit(int price, List<Integer> hitNumber) {
        double totalPrize = 0.0;
        for (Integer i : hitNumber) {
            totalPrize += Prize.calculatePrize(i);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        String profit = df.format(1 + ((totalPrize - price) / price));
        return Double.parseDouble(profit);
    }

    public static List<Integer> hitNumber(List<Lotto> lottos, Set<Integer> wonNumber) {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCount.add(lotto.matchedNumber(wonNumber));
        }
        return matchCount;
    }
}
