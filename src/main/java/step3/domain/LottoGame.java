package step3.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static LottoTickets lottoTickets;

    // pay
    public int calculateGameCountByPayMoney(Money money) {

        int buyCount = money.getPayedMoney() / LOTTO_PRICE;
        if (buyCount < 1) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return buyCount;
    }

    // issue
    public static void issueLotto(int gameCount) {

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottoList.add(Lotto.auto());
        }

        lottoTickets = new LottoTickets(lottoList);

    }

    // matching
    public void matchingWinningNumbers(WinningLotto winningLotto) {
        winningLotto.matchingWinningNumbers(lottoTickets);
    }

    // winningResult
    public BigDecimal totalResult() {

        BigDecimal sum = BigDecimal.valueOf(Arrays.stream(Prize.values())
                .mapToLong(prize -> prize.getPrizeTotal())
                .sum());

        return sum.divide(BigDecimal.valueOf(lottoTickets.getLottoTicketsSize() * LOTTO_PRICE), 3, BigDecimal.ROUND_HALF_EVEN);
    }


    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }


}
