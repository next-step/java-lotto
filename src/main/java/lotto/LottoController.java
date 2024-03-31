package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        Amount amount = InputView.askPurchaseAmount();
        ManualLottoCount manualLottoCount = InputView.askManualLottoCount(amount);
        List<LottoTicket> manualLottoNumbers = InputView.askManualLottoNumbers(manualLottoCount);

        LottoTickets lottoTickets = new LottoTickets(amount, manualLottoNumbers);
        ResultView.printLottoTickets(lottoTickets, manualLottoCount);

        LottoTicket winningNumbers = InputView.askWinningNumbers();
        LottoNumber bonusBall = InputView.askBonusBall(winningNumbers);
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusBall);

        ResultView.printLottoResult(lottoTickets.winnerResult(winningTicket));
    }

}
