package step2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static List<Rank> ranks = new ArrayList<>();

    public LottoResult(WinningLotto winningLotto, List<Lotto> buyLottoList) {
        for (Lotto lotto : buyLottoList) {
            addRank(match(winningLotto, lotto));
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

    private static int match(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber winNumber : winningLotto.getWinningNumber()) {
            matchCount += lotto.contains(winNumber) ? 1 : 0;
        }
        return matchCount;
    }

    public BigDecimal getTotalRevenue(int purchasePrice) {
        double total = 0;
        for (Rank rank : ranks) {
            total += rank.getWinPrice();
        }
        return new BigDecimal(total / purchasePrice).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
