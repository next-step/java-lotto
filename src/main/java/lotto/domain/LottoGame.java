package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoGame {

    public LottoGame() {
    }

    public LottoTickets buy(int money) {
        final LottoMoney lottoMoney = new LottoMoney(money);
        final int gameCount = calculateAutoGameCount(lottoMoney);
        return new LottoTickets(gameCount);
    }

    public LottoGameResults getResults(LottoTickets boughtTickets, List<Integer> winningNumber) {
        return LottoGameMatcher.matchWinningNumber(boughtTickets, new LottoNumber(winningNumber));
    }

    private int calculateAutoGameCount(LottoMoney lottoMoney) {
        return Math.floorDiv(lottoMoney.convertToInt(), DEFAULT_GAME_PRICE);
    }

}
