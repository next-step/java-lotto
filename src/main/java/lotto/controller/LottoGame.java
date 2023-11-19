package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.PrizeStatus;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Random;

public class LottoGame {

    public void start(Random random) {

        int purchasedAmt = InputView.getAmountOfPurchase();
        int numOfTickets = purchasedAmt / 1000;
        OutputView.displayNumberOfPurchasedTickets(purchasedAmt);

        LottoFactory lottoFactory = new LottoFactory(numOfTickets, random);
        OutputView.displayLottoTickets(lottoFactory);

        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoFactory.generateTicket(random));

        OutputView.displayWinnerNumbers(winnerNumbers);
        PrizeStatus prizeStatus = new PrizeStatus(lottoFactory, winnerNumbers);

        OutputView.displayPrizeStatMessage();
        OutputView.displayPrizeStatus(prizeStatus);
        OutputView.displayProfit(prizeStatus.calculateProfit(purchasedAmt));
    }
}
