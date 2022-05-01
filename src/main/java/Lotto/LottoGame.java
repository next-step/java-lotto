package Lotto;

import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.Map;

public class LottoGame {

    private MyLottoList myLottoList = new MyLottoList();

    private int buyMoney = 0;
    private int[] winningNumbers = new int[6];

    public void start() {
        inputBuyMoney();

        viewMyLottoNumbers();

        inputWinningLottoNumbers();

        viewResult();
    }

    private void inputBuyMoney() {
        myLottoList.createLottoNumbers(changeMoneyToLottoNum());
    }

    private int changeMoneyToLottoNum() {
        buyMoney = InputView.inputBuyMoney();
        return buyMoney / 1000;
    }

    private void viewMyLottoNumbers() {
        ResultView.viewLottoNumbers(myLottoList);
    }

    private void inputWinningLottoNumbers() {
        splitAndCastWinningNumber(InputView.inputWinningLottoNumbers());
    }

    private void splitAndCastWinningNumber(String winningLottoNumbersStr) {
        String[] winningNumbersArr = winningLottoNumbersStr.split(",");

        for (int i = 0; i < winningNumbersArr.length; ++i) {
            winningNumbers[i] = Integer.parseInt(winningNumbersArr[i]);
        }
    }

    private void viewResult() {
        Map<Integer,Integer> result = myLottoList.checkWinningLotto(winningNumbers);

        ResultView.viewResultBoard(result);

        ResultView.viewLottoYield(result, buyMoney);
    }
}
