package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoGame;
import lotto.domain.PrizeStatus;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Random;

import static lotto.view.OutputView.*;
import static lotto.view.OutputView.displayNumberOfPurchasedTickets;

public class LottoPlayApplication {
    public LottoPlayApplication() {
    }

    public static void main (String [] arg) {
        Random random = new Random();

        int purchasedAmt = InputView.getAmountOfPurchase();
        int numOfTickets = purchasedAmt / 1000;
        displayNumberOfPurchasedTickets(purchasedAmt);

        LottoGame lottoGame = new LottoGame(numOfTickets, random);

        displayLottoTickets(lottoGame.tickets());

        displayWinnerNumbers(lottoGame.winnerNumbers());

        PrizeStatus prizeStatus = new PrizeStatus(lottoGame);

        displayResult(prizeStatus, purchasedAmt);
    }
}
