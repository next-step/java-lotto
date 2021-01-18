package lotto;

import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerLottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Integer money = inputView.inputLottoMoney();
        Integer inputManualLottoTicketCount = inputView.inputManualLottoTicketCount();
        List<String> inputManualLottoTicketNumber = inputView.inputManualLottoTicketNumber(inputManualLottoTicketCount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoTickets lottoTickets = new LottoTickets(lottoGenerator.buyLottoTicket(money));

        OutputView outputView = new OutputView();
        outputView.printLottoTicket(lottoTickets);
        String inputLottoWinnerNumber = inputView.inputLottoWinnerNumber();
        String bonusNumber = inputView.inputLottoWinnerBonusNumber();
        WinnerLottoTicket lottoTicket = new WinnerLottoTicket(inputLottoWinnerNumber, bonusNumber);

        outputView.printLottoResult(lottoTicket, lottoTickets);

    }
}
