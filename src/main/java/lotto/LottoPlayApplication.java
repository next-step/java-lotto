package lotto;

import lotto.domain.LottoGame;
import lotto.domain.PrizeStatus;
import lotto.view.InputView;

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
        int bonusBall = InputView.getBonusBall();
        lottoGame.winnerNumbers().throwBonusBall(bonusBall);

        PrizeStatus prizeStatus = lottoGame.processResult();
        displayResult(prizeStatus, purchasedAmt);
    }
}
