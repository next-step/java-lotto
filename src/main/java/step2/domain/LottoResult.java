package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static List<Rank> ranks = new ArrayList<>();

    public LottoResult(int[] winNumber, List<Lotto> buyLottoList) {
        for (Lotto lotto : buyLottoList) {
            addRank(match(winNumber, lotto));
        }
    }

    public List<Rank> getRanks() {
        return this.ranks;
    }

    public static void addRank(int matchCount) {
        if (matchCount >= 3) {
            ranks.add(Rank.rank(matchCount));
        }
    }

    private static int match(int[] winNumbers, Lotto lotto) {
        int matchCount = 0;
        for (int winNumber : winNumbers) {
            matchCount += lotto.contains(winNumber) ? 1 : 0;
        }
        return matchCount;
    }

    public double getTotalRevenue(int purchasePrice) {
        double total = 0;
        for (Rank rank : ranks) {
            total += rank.getWinPrice();
        }
        return (total / purchasePrice);
    }
}
