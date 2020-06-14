package step3.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static LottoTickets lottoTickets;

    public LottoGame(Money money) {
        int buyCount = calculateGameCountByPayMoney(money);
        issueLotto(buyCount);
    }

    // pay
    private static int calculateGameCountByPayMoney(Money money) {
        int buyCount = money.getPayedMoney() / LOTTO_PRICE;
        if (buyCount < 1) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return buyCount;
    }

    // issue
    private static LottoTickets issueLotto(int gameCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottoList.add(Lotto.auto());
        }
        lottoTickets = new LottoTickets(lottoList);
        return lottoTickets;
    }

    // matching
    public void matchingWinningNumbers(WinningLotto winningLotto) {
        winningLotto.matchingWinningNumbers(lottoTickets);
    }

    // winningResult
    public BigDecimal totalResult() {
        PrizeCount prizeCount = PrizeCount.getInstance();
        return prizeCount.getPrizeTotalSum();
    }
    
    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

}
