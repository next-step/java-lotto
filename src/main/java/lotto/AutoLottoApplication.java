package lotto;

import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.LottoStore;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningNumbers;
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

        WinningNumbers winningNumbers = new WinningNumbers(InputView.askLastWeekWinningNumbers());
        LottoResult lottoResult = lottoTickets.getLottoResult(winningNumbers);

        OutputView.printResult(lottoResult, totalMoney);
    }
}
