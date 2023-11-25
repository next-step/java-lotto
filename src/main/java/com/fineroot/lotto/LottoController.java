package com.fineroot.lotto;

import com.fineroot.lotto.domain.LottoStore;
import com.fineroot.lotto.view.InputView;
import com.fineroot.lotto.view.ResultView;
import com.fineroot.lotto.viewmodel.InputViewModel;
import com.fineroot.lotto.viewmodel.ResultViewModel;

public class LottoController {

    private final LottoStore lottoStore;
    private final InputViewModel inputViewModel;
    private final ResultViewModel resultViewModel;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoStore lottoStore, InputViewModel inputViewModel, ResultViewModel resultViewModel) {
        this.lottoStore = lottoStore;
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
        this.inputView = new InputView(inputViewModel);
        this.resultView = new ResultView(resultViewModel);
    }

    public void startLotteryGame() {
        purchaseLottery();
        matchWithWinningNumber();
    }

    private void matchWithWinningNumber() {
        inputView.drawInputWinningNumberView();
        resultViewModel.saveWinnerStatus(lottoStore.winnerStatus(inputViewModel.getWinningNumberSet()));
        resultView.drawStatistics();
    }

    private void purchaseLottery() {
        inputView.drawLotteryPurchaseView();
        lottoStore.purchaseLottery(inputViewModel.getLotteryOrder());
        resultViewModel.saveLotteryBundleStatus(lottoStore.lottoBundleStatus());
        resultViewModel.saveLotteryCountSet(inputViewModel.getLotteryOrderSet());
        resultView.drawEachLotteryCount();
        resultView.drawLotteryBundleStatus();
    }


}
