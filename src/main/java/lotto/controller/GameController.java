package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberStragey;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    List<LottoNumber> buyLotto;
    LottoNumber winningNumber;

    public GameController() {
        buyLotto = new ArrayList<>();
        winningNumber = new LottoNumber();
    }

    public void init() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int buyLottoMoney = inputView.buyLottoView();

        for(int count = 0; count < buyLottoMoney / InputView.MINIMUM_LOTTO_MONEY; count++) {
            buyLotto.add(new LottoNumber(new LottoNumberStragey()));
        }

        resultView.lottoNumberView(buyLotto);
        winningNumber.setWinningNumber(inputView.winningLottoView());

    }

}
