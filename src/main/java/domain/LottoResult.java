package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.util.Arrays.asList;

public class LottoResult {

    private List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int matchCount(Rank selectedRank) {
        return (int) ranks.stream()
                .filter(jackpot -> jackpot.equals(selectedRank))
                .count();
    }

    public List<Rank> getRanks() {
        return asList(Rank.FIFTH,
                Rank.FOURTH,
                Rank.THIRD,
                Rank.SECOND,
                Rank.FIRST);
    }

    public double calculatorRate() {
        int totalPrizeMoney = getTotalPrizeMoney();
        double rate = (double)totalPrizeMoney / getPaidLotto();
        return new BigDecimal(rate)
                .setScale(2, RoundingMode.DOWN)
                .doubleValue();
    }

    private int getPaidLotto() {
        return Lotto.PRICE * ranks.size();
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Rank rank : getRanks()) {
            totalPrizeMoney += rank.getTotalPrizeMoney(matchCount(rank));
        }
        return totalPrizeMoney;
    }
}
