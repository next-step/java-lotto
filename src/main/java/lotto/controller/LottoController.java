package lotto.controller;

import lotto.domain.LottoNum;
import lotto.domain.LottoTickets;
import lotto.domain.Winner;
import lotto.serivce.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        int manualLottoCount = InputView.getManualLottoCount();

        List<String> manualLotto = InputView.getManualLotto(manualLottoCount);

        LottoTickets lottoTickets = LottoService.buyTickets(purchaseAmount, manualLotto);
        ResultView.printLottoTickets(manualLottoCount, lottoTickets);

        String lastWeekWinningInput = InputView.getLastWeekWinningNumbers();

        LottoNum bonus = new LottoNum(InputView.getBonus(), lastWeekWinningInput);

        Winner winner = LottoService.match(lottoTickets, lastWeekWinningInput, bonus);
        ResultView.printWinnerStatistics(winner);

    }
}
