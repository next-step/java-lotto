package Lotto.controller;

import Lotto.Lottos;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private Lottos lottos = new Lottos();

    private int buyMoney = 0;
    private List<Integer> winningNumbers = new ArrayList<>();

    public void start() {
        inputBuyMoney();

        viewMyLottoNumbers();

        inputWinningLottoNumbers();

        viewResult();
    }

    private void inputBuyMoney() {
        lottos.createLottoNumbers(changeMoneyToLottoNum());
    }

    private int changeMoneyToLottoNum() {
        buyMoney = InputView.inputBuyMoney();
        return buyMoney / 1000;
    }

    private void viewMyLottoNumbers() {
        ResultView.viewLottoNumbers(lottos);
    }

    private void inputWinningLottoNumbers() {
        splitAndCastWinningNumber(InputView.inputWinningLottoNumbers());
    }

    private void splitAndCastWinningNumber(String winningLottoNumbersStr) {
        String[] winningNumbersArr = winningLottoNumbersStr.split(",");

        for (int i = 0; i < 6; ++i) {
            winningNumbers.add(Integer.parseInt(winningNumbersArr[i]));
        }
    }

    private void viewResult() {
        Map<Integer, Integer> result = lottos.checkWinningLotto(winningNumbers);

        ResultView.viewResultBoard(result);

        ResultView.viewLottoYield(result, buyMoney);
    }
}
