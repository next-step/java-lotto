package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoGame {
    private final LottoMoney lottoMoney;
    private final int gameCount;

    public LottoGame(int money) {
        this.lottoMoney = new LottoMoney(money);
        this.gameCount = calculateAutoGameCount();
    }

    public LottoTickets buy() {
        return new LottoTickets(gameCount);
    }

    public LottoGameResults getResults(LottoTickets boughtTickets, List<Integer> winningNumber) {
        return LottoGameMatcher.matchWinningNumber(boughtTickets, new LottoNumber(winningNumber));
    }

    int calculateAutoGameCount() {
        return Math.floorDiv(lottoMoney.convertToInt(), DEFAULT_GAME_PRICE);
    }

}
