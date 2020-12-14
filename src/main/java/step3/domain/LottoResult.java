package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static List<Rank> ranks = new ArrayList<>();
    private static final int MIN_MATCH_COUNT = 3;

    public LottoResult(WinningLotto winningLotto, List<Lotto> buyLottoList) {
        for (Lotto lotto : buyLottoList) {
            addRank(winningLotto.match(lotto), winningLotto.matchBonus(lotto));
        }
    }

    public List<Rank> getRanks() {
        return this.ranks;
    }

    public static void addRank(int matchCount, boolean matchBonus) {
        if (matchCount >= MIN_MATCH_COUNT) {
            ranks.add(Rank.valueOf(matchCount, matchBonus));
        }
    }

    public BigDecimal getTotalRevenue(int purchasePrice) {
        double total = 0;
        for (Rank rank : ranks) {
            total += rank.getWinningMoney();
        }

        BigDecimal reword = BigDecimal.valueOf(total);
        BigDecimal amount = BigDecimal.valueOf(purchasePrice);

        return reword.divide(amount, 2, RoundingMode.FLOOR);
    }
}
