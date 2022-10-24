package com.nextstep.lotto.lottoGame;

import com.nextstep.lotto.lottoGame.domain.LottoResult;
import com.nextstep.lotto.lottoGame.domain.LottoTickets;
import com.nextstep.lotto.lottoGame.view.InputView;
import com.nextstep.lotto.lottoGame.view.OutputView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoTickets lottoTickets = LottoTickets.ofBudget(InputView.getBudget());
        OutputView.drawPublishResult(lottoTickets);

        List<Integer> winningNumbers = InputView.getLottoNumbers();
        int bonusNumber = InputView.getBonusNumber();

        LottoResult result = new LottoResult(winningNumbers, bonusNumber, lottoTickets);
        OutputView.drawResult(result, lottoTickets.getUsedBudget());
    }
}
