package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        /** 구입금액 입력 */
        int payAmount = inputView.inputPayAmount();

        /** 수동 구매 로또 수 입력 입력 */
        int manualLottoTicketCount = inputView.inputManualLottoTicketCount();

        /** 수동 구매할 로또 번호 입력 */
        inputView.printManualLottoNumbers();
        LottoTicketBundle manualLottoTickets = inputView.inputManualLottoNumbers(manualLottoTicketCount);

        /** 자동 구매 로또 생성 */
        LottoTicketBundle autoLottoTickets = lottoService.createAutoLottoTickets(payAmount, manualLottoTicketCount);
        LottoTicketBundle userLottoTickets = new LottoTicketBundle(manualLottoTickets, autoLottoTickets);

        /** 구매한 수동, 자동 로또 티켓 출력 */
        resultView.printLottoTicketCounts(manualLottoTicketCount, autoLottoTickets.getLottoTickets().size());
        resultView.printUserLottoTickets(userLottoTickets);

        /** 당첨 번호, 보너스 볼 입력 */
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(inputView.inputWinningNumbers()), new LottoNumber(inputView.inputBonusNumber()));

        /** 당첨 통계 출력 */
        resultView.printLottoResult(lottoService.calculateResult(userLottoTickets, winningLotto), payAmount);
    }
}
