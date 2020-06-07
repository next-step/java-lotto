package com.cheolhyeonpark.lotto;

import com.cheolhyeonpark.lotto.domain.LottoManager;
import com.cheolhyeonpark.lotto.domain.Amount;
import com.cheolhyeonpark.lotto.domain.Count;
import com.cheolhyeonpark.lotto.domain.number.LottoTicket;
import com.cheolhyeonpark.lotto.domain.number.Number;
import com.cheolhyeonpark.lotto.domain.number.Numbers;
import com.cheolhyeonpark.lotto.domain.number.WinningNumbers;
import com.cheolhyeonpark.lotto.view.InputView;
import com.cheolhyeonpark.lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoManager lottoManager = new LottoManager(new LottoTicket());

    public void run() {
        Amount amount = new Amount(inputView.inputAmount());
        Count manualCount = new Count(inputView.inputManualCount());
        resultView.printLottoNumbersList(lottoManager.createLottoNumbers(amount.getAutoCount(manualCount),
                inputView.inputManualNumbers(manualCount.getCount())));

        resultView.printGameResult(lottoManager
                .getGameResult(new WinningNumbers(new Numbers(inputView.inputWinningNumber()),
                new Number(inputView.inputBonusNumber()))), amount);
    }

    public static void main(String[] args) {
        new LottoController().run();
    }
}
