package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningTicket;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Money;

public class AutoLottoApplication {

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(new LottoTicketGenerator());

        Money budget = Money.of(InputView.askTotalMoney());
        int numberOfManualLottoTicket = InputView.askNumberOfManualLottoTicket();

        LottoTickets manualTickets = InputView.askManualTicketNumbers(numberOfManualLottoTicket);
        LottoTickets lottoTickets = lottoStore.buy(budget);

        OutputView.printLottoTicketNumbers(lottoTickets);

        WinningTicket winningTicket = makeWinningTicket();
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);
        OutputView.printResult(lottoResult);
    }

    private static WinningTicket makeWinningTicket() {
        LottoTicket winningLottoTicket = new LottoTicket(InputView.askLastWeekWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.askBonusNumber());
        return new WinningTicket(winningLottoTicket, bonusNumber);
    }
}
