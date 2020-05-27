package lotto;

import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.LottoNumber;
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

        Money totalMoney = new Money(InputView.askTotalMoney());
        LottoTickets lottoTickets = lottoStore.buy(totalMoney);

        OutputView.printLottoTicketNumbers(lottoTickets);

        LottoTicket winningLottoTicket = new LottoTicket(InputView.askLastWeekWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.askBonusNumber());
        WinningTicket winningTicket = new WinningTicket(winningLottoTicket, bonusNumber);
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);

        OutputView.printResult(lottoResult, totalMoney);
    }
}
