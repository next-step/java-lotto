package lotto.controller;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumberRandomSelector;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int price = inputView.inputPrice();
        LottoGame lottoGame = new LottoGame(price, new LottoNumberRandomSelector());
        outputView.printBasicInfo(lottoGame);

        List<Integer> numbers = inputView.inputLastWinningNumber();
        LottoNumbers winningNumbers = new LottoNumbers(numbers);

        LottoResult lottoResult = new LottoResult(lottoGame.checkResult(winningNumbers));

        outputView.printResult(lottoResult.getResult());
        outputView.printProfitRatio(lottoResult.getProfitRate(price));
    }
}
