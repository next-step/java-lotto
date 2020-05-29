package com.cheolhyeonpark.lotto;

import com.cheolhyeonpark.lotto.domain.AutoGenerator;
import com.cheolhyeonpark.lotto.domain.LottoManager;
import com.cheolhyeonpark.lotto.domain.LottoNumbersList;
import com.cheolhyeonpark.lotto.view.InputView;
import com.cheolhyeonpark.lotto.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        int amount = inputView.inputAmount();
        LottoManager lottoManager = new LottoManager(new LottoNumbersList(), new AutoGenerator());
        resultView.printLottoNumbersList(lottoManager.createLottoNumbers(amount));
        resultView.printGameResult(lottoManager
                .getGameResult(Arrays.stream(inputView.inputWinningNumber().replaceAll(" ", "")
                        .split(",")).map(Integer::parseInt).collect(Collectors.toList())), amount);
    }

    public static void main(String[] args) {
        new LottoController().run();
    }
}
