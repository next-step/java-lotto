package step3.domain;

import step2.domain.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static List<step2.domain.Rank> ranks = new ArrayList<>();
    private static final int MIN_MATCH_COUNT = 3;

    public LottoResult(Lotto winningLotto, List<Lotto> buyLottoList) {
        for (Lotto lotto : buyLottoList) {
            addRank(lotto.match(winningLotto));
        }
    }

    public List<step2.domain.Rank> getRanks() {
        return this.ranks;
    }

    public static void addRank(int matchCount) {
        if (matchCount >= MIN_MATCH_COUNT) {
            ranks.add(step2.domain.Rank.rank(matchCount));
        }
    }

    public BigDecimal getTotalRevenue(int purchasePrice) {
        double total = 0;
        for (Rank rank : ranks) {
            total += rank.getWinPrice();
        }

        BigDecimal reword = BigDecimal.valueOf(total);
        BigDecimal amount = BigDecimal.valueOf(purchasePrice);

        return reword.divide(amount, 2, RoundingMode.FLOOR);
    }
}
