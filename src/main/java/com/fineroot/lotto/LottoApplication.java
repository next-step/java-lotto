package com.fineroot.lotto;

import com.fineroot.lotto.domain.LottoStore;
import com.fineroot.lotto.viewmodel.InputViewModel;
import com.fineroot.lotto.viewmodel.ResultViewModel;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoStore(), new InputViewModel(),
                new ResultViewModel());
        lottoController.startLotteryGame();
    }
}
