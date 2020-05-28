package com.cheolhyeonpark.lotto;

import com.cheolhyeonpark.lotto.view.InputView;
import com.cheolhyeonpark.lotto.view.ResultView;

public class LottoManager {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoManager(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
}
