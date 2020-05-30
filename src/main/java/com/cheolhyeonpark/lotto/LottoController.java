package com.cheolhyeonpark.lotto;

import com.cheolhyeonpark.lotto.domain.LottoManager;
import com.cheolhyeonpark.lotto.domain.LottoNumbersList;
import com.cheolhyeonpark.lotto.domain.WinningNumbers;
import com.cheolhyeonpark.lotto.view.InputView;
import com.cheolhyeonpark.lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();


    public void run() {
        int amount = inputView.inputAmount();
        LottoManager lottoManager = new LottoManager(new LottoNumbersList());
        resultView.printLottoNumbersList(lottoManager.createLottoNumbers(amount));
        resultView.printGameResult(lottoManager.getGameResult(new WinningNumbers(inputView.inputWinningNumber())), amount);
    }

    public static void main(String[] args) {
        new LottoController().run();
    }
}
