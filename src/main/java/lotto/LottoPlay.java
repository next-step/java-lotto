package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoTickets;
import lotto.domain.PrizeStatus;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Random;

public class LottoPlay {
    public static void main (String [] arg) {
        Random random = new Random();

        OutputView.requestAmountOfPurchase();
        int purchasedAmt = InputView.getAmountOfPurchase();
        int numOfTickets = purchasedAmt / 1000;
        OutputView.displayNumberOfPurchasedTickets(purchasedAmt);

        LottoTickets lottoTickets = new LottoTickets(numOfTickets, random);
        OutputView.displayLottoTickets(lottoTickets);

        LottoFactory lottoFactory = new LottoFactory(random);
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoFactory.numbers());

        OutputView.displayWinnerNumbers(winnerNumbers);
        PrizeStatus prizeStatus = new PrizeStatus(lottoTickets, winnerNumbers);

        OutputView.displayPrizeStatMessage();
        OutputView.displayPrizeStatus(prizeStatus);
    }

}
