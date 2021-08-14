package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoGame lottoGame;
    private final LottoWinner lottoWinner = new LottoWinner();

    public Lotto(final int price) {
        lottoGame = new LottoGame(price);
    }

    public int getGameNum(){
        return lottoGame.getTicketNum();
    }

    public void setWinningNumbers(final String winningNumbersString){
        lottoWinner.selectWinningNumbers(winningNumbersString);
    }

    public LottoWinner getLottoWinner(){
        return lottoWinner;
    }
}
