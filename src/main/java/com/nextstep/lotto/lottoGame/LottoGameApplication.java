package com.nextstep.lotto.lottoGame;

import com.nextstep.lotto.lottoGame.domain.LottoResult;
import com.nextstep.lotto.lottoGame.domain.LottoTickets;
import com.nextstep.lotto.lottoGame.domain.WinningNumbers;
import com.nextstep.lotto.lottoGame.view.InputView;
import com.nextstep.lotto.lottoGame.view.OutputView;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoTickets lottoTickets = LottoTickets.ofBudget(InputView.getBudget());
        OutputView.drawPublishResult(lottoTickets);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.getLottoNumbers(), InputView.getBonusNumber());
        LottoResult result = new LottoResult(winningNumbers, lottoTickets);
        OutputView.drawResult(result, lottoTickets.getUsedBudget());
    }
}
