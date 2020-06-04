package com.cheolhyeonpark.lotto;

import com.cheolhyeonpark.lotto.domain.BonusNumber;
import com.cheolhyeonpark.lotto.domain.LottoManager;
import com.cheolhyeonpark.lotto.domain.LottoNumbersList;
import com.cheolhyeonpark.lotto.domain.NumbersGenerator;
import com.cheolhyeonpark.lotto.view.InputView;
import com.cheolhyeonpark.lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoManager lottoManager = new LottoManager(new LottoNumbersList(), new NumbersGenerator());

    public void run() {
        int amount = inputView.inputAmount();
        resultView.printLottoNumbersList(lottoManager.createLottoNumbers(amount));
        resultView.printGameResult(lottoManager
                .getGameResult(inputView.inputWinningNumber(), inputView.inputBonusNumber()), amount);
    }

    public static void main(String[] args) {
        new LottoController().run();
    }
}
