package lotto;

import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.BonusNumber;
import lotto.domain.LottoStore;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningTicket;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Money;

public class AutoLottoApplication {

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(new AutoLottoNumberGenerator());

        Money budget = Money.of(InputView.askTotalMoney());
        LottoTickets lottoTickets = lottoStore.buy(budget);

        OutputView.printLottoTicketNumbers(lottoTickets);

        WinningTicket winningTicket = makeWinningTicket();
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);

        OutputView.printResult(lottoResult, budget);
    }

    private static WinningTicket makeWinningTicket() {
        LottoTicket winningLottoTicket = new LottoTicket(InputView.askLastWeekWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.askBonusNumber());
        return new WinningTicket(winningLottoTicket, bonusNumber);
    }
}
