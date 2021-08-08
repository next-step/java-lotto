package lotto.controller;

import lotto.model.LottoGame;
import lotto.type.Winning;
import lotto.view.Input;
import lotto.view.Result;

import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int DEFAULT_LOTTO_AMOUNT = 0;

    private LottoGame lottoGame;

    public void playGame() {

        int purchaseAmount = Input.getPurchaseAmount();
        lottoGame = new LottoGame();

        int lottoAmount = lottoGame.getLottoAmount(purchaseAmount);
        Result.printLottoAmount(lottoAmount);

        if (lottoAmount == DEFAULT_LOTTO_AMOUNT) {
            return;
        }

        List<List<Integer>> lottoNumbers = lottoGame.generateNumbers();
        Result.printLottoNumbers(lottoNumbers);

        gameStart(lottoNumbers);
    }

    private void gameStart(List<List<Integer>> lottoNumbers) {
        String inputNumbers = Input.getPastLottoNumber();
        try {
            lottoGame.settingWinningNumber(inputNumbers);
        } catch (IllegalArgumentException e) {
            Result.notValidNumber();
            return;
        }
        Map<Winning, Integer> winningCount = lottoGame.setWinningCount(lottoNumbers);
        Result.printWinningResult(winningCount);

        double margin = lottoGame.getMargin(winningCount);
        Result.printMargin(margin);
    }


}
