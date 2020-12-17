package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    private static List<Rank> ranks = new ArrayList<>();

    public LottoResult(WinningLotto winningLotto, List<Lotto> buyLottoList) {
        for (Lotto lotto : buyLottoList) {
            ranks.add(Rank.valueOf(winningLotto.match(lotto), winningLotto.matchBonus(lotto)));
        }
    }

    public List<Rank> getRanks() {
        return Collections.unmodifiableList(this.ranks);
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
