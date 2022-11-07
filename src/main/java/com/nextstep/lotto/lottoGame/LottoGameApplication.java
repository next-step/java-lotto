package com.nextstep.lotto.lottoGame;

import com.nextstep.lotto.lottoGame.domain.*;
import com.nextstep.lotto.lottoGame.view.InputView;
import com.nextstep.lotto.lottoGame.view.OutputView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {

        int budget = InputView.getBudget();
        int manualCount = InputView.getManualCount();
        LottoStore.checkBudget(budget, manualCount);

        final List<LottoTicket> manualLottoNumbers = InputView.getManualLottoNumbers(manualCount);
        LottoTickets lottoTickets = LottoStore.buyTicketsWithManual(budget, manualLottoNumbers);
        OutputView.drawPublishResult(lottoTickets, manualCount);

        WinningNumbers winningNumbers = InputView.getLottoNumbers();
        LottoResult result = new LottoResult(winningNumbers, lottoTickets);
        OutputView.drawResult(result, lottoTickets.getUsedBudget());
    }
}
