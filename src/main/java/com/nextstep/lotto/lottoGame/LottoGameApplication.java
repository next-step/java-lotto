package com.nextstep.lotto.lottoGame;

import com.nextstep.lotto.lottoGame.domain.LottoResult;
import com.nextstep.lotto.lottoGame.domain.LottoTicket;
import com.nextstep.lotto.lottoGame.domain.LottoTickets;
import com.nextstep.lotto.lottoGame.domain.WinningNumbers;
import com.nextstep.lotto.lottoGame.view.InputView;
import com.nextstep.lotto.lottoGame.view.OutputView;

import java.util.Collections;
import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {

        int budget = InputView.getBudget();
        int manualCount = InputView.getManualCount();
        List<LottoTicket> manualTickets = Collections.EMPTY_LIST;
        if (manualCount > 0) {
            manualTickets = InputView.getManualLottoNumbers(manualCount);
        }

        LottoTickets lottoTickets = LottoTickets.ofBudgetAndNumbers(budget, manualTickets);
        OutputView.drawPublishResult(lottoTickets, manualCount);

        WinningNumbers winningNumbers = InputView.getLottoNumbers();
        LottoResult result = new LottoResult(winningNumbers, lottoTickets);
        OutputView.drawResult(result, lottoTickets.getUsedBudget());
    }
}
