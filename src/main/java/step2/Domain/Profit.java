package step2.Domain;

import java.util.Collections;
import java.util.TreeMap;

public class Profit {

    private Money money;
    private Rank rank;

    public Profit(Money money, Rank rank) {
        this.money = money;
        this.rank = rank;
    }

    public double profitRate() {
        return profitSum() / money.getMoney();
    }

    public double profitSum() {
        return rank.getRank().keySet().stream().
                mapToDouble(lottoPrize -> lottoPrize.prize() * rank.size(lottoPrize)).sum();
    }

    public TreeMap<LottoPrize, Integer> profitList() {
        TreeMap<LottoPrize, Integer> profitList = new TreeMap<>(Collections.reverseOrder());
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            profitList.put(lottoPrize, rank.size(lottoPrize));
        }
        return profitList;
    }
}
