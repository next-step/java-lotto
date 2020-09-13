package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMachine {

    public static void main(String[] args) {
        Payment payment = howMuch();
        LottoBundle bundle = new LottoBundle();

        int slipCount = buyTickets(payment);

        pickingNumbers(slipCount, bundle);
        bundle.addTickets(LottoFactory.generateLotto(payment.remaining()));

        ResultView.showTickets(bundle);

        WinningLotto winningNumbers = WinningLotto.of(InputView.getWinningNumbers(), InputView.getBonusNumber());

        LottoResult result = bundle.drawing(winningNumbers);
        ResultView.showDrawingResult(result);
    }

    private static Payment howMuch() {
        Payment payment = null;
        try {
            payment = new Payment(InputView.howMuch());
        } catch (IllegalArgumentException  e) {
            System.out.println(e.getMessage());
            return howMuch();
        }
        return payment;
    }

    private static int buyTickets(Payment payment) {
        int slipCount = 0;
        try {
            slipCount = InputView.howManySlips();
            payment.buyTickets(slipCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyTickets(payment);
        }
        return slipCount;
    }

    private static void pickingNumbers(int slipCount, LottoBundle bundle) {
        while (slipCount-- > 0) {
            List<Integer> pickedNumbers = InputView.getPickedNumbers();
            try {
                bundle.addTicket(LottoNumbers.of(pickedNumbers));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                slipCount++;
            }
        }
    }
}
