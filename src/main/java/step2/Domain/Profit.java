package step2.Domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> profitList() {

        List<String> profits = new ArrayList<>();
        for(LottoPrize lottoPrize : LottoPrize.values()){
            profits.add(String.format("%d개 일치 (%d)원 - %d개",
                    lottoPrize.hitCount().getHit(), lottoPrize.prize(), rank.size(lottoPrize)));
        }
        return profits;
    }

}
