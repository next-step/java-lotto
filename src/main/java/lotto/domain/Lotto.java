package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoWinner lottoWinner = new LottoWinner();
    private final LottoGame lottoGame;

    public Lotto(final int price) {
        lottoGame = new LottoGame(price);
    }

    public int getGameNum() {
        return lottoGame.getTicketNum();
    }

    public void setWinningNumbers(final String winningNumbersString) {
        lottoWinner.selectWinningNumbers(winningNumbersString);
    }

    public List<Integer> getWinningNumber() {
        return lottoWinner.getWinningNumbers();
    }
}
