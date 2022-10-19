package com.nextstep.lotto.lottoGame;

import com.nextstep.lotto.lottoGame.domain.LottoGame;
import com.nextstep.lotto.lottoGame.domain.LottoResult;
import com.nextstep.lotto.lottoGame.view.InputView;
import com.nextstep.lotto.lottoGame.view.OutputView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {

        LottoGame lotto = LottoGame.byBudget(InputView.getBudget());
        OutputView.drawPublishResult(lotto.getTickets());

        List<Integer> winningNumbers = InputView.getLottoNumbers();
        LottoResult result = lotto.result(winningNumbers);
        OutputView.drawResult(result, lotto.getUsedBudget());
    }
}
