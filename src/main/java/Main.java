import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.ManualLottoCount;
import lotto.model.wrapper.Payment;
import lotto.view.InputView;

import static lotto.view.OutputView.printLottoResults;
import static lotto.view.OutputView.printLottoTickets;

public class Main {

    public static void main(String[] args) {
        Payment payment = InputView.inputData(InputView::inputPayment);

        ManualLottoCount manualLottoCount = InputView.inputData(InputView::inputManualLottoCount);

        LottoTickets manualLottoTickets = InputView.inputData(manualLottoCount, InputView::inputManualLotto);

        LottoTickets lottoTickets = LottoStore.sell(payment, manualLottoTickets);

        printLottoTickets(lottoTickets, manualLottoTickets.size());

        WinningLottoTicket winningLottoTicket = inputWinningLottoTicket();

        printLottoResults(lottoTickets.checkAll(winningLottoTicket));
    }

    private static WinningLottoTicket inputWinningLottoTicket() {
        LottoTicket winningLottoTicket = InputView.inputData(InputView::inputWinningNumber);

        LottoNumber bonusNumber = InputView.inputData(InputView::inputBonusNumber);

        return WinningLottoTicket.newInstance(winningLottoTicket, bonusNumber);
    }

}
