import lotto.model.LottoPurchaseTickets;
import lotto.model.LottoStore;
import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.Payment;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.utils.LottoUtil.convertTo;
import static lotto.view.InputView.*;
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
        Set<LottoNumber> winningNumbers = convertTo(winningNumberString).stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());

        int bonusNumber = inputBonusNumber();

        return WinningLottoTicket.newInstance(winningNumbers, LottoNumber.of(bonusNumber));
    }

}
