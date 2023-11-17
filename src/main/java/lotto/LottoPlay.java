package lotto;

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

    }

}
