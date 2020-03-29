import lotto.model.LottoPurchaseTickets;
import lotto.model.LottoStore;
import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.Payment;
import lotto.utils.LottoNumberAdaptor;

import java.util.List;

import static lotto.utils.LottoUtil.convertTo;
import static lotto.view.InputView.inputPayment;
import static lotto.view.InputView.inputWinningNumber;
import static lotto.view.OutputView.printLottoResults;
import static lotto.view.OutputView.printLottoTickets;

public class Main {

    public static void main(String[] args) {
        Payment payment = Payment.of(inputPayment());
        LottoPurchaseTickets lottoPurchaseTickets = LottoStore.sell(payment);

        printLottoTickets(lottoPurchaseTickets);

        WinningLottoTicket winningLottoTicket = inputWinningLottoTicket();

        printLottoResults(lottoPurchaseTickets.checkAll(winningLottoTicket));
    }

    private static WinningLottoTicket inputWinningLottoTicket() {
        String winningNumberString = inputWinningNumber();
        List<Integer> winningNumbers = convertTo(winningNumberString);
        return WinningLottoTicket.newInstance(LottoNumberAdaptor.convert(winningNumbers));
    }

}