package step2.controller;

import step2.View.InputView;
import step2.View.ResultView;
import step2.View.RuntimeView;
import step2.domain.Judge;
import step2.domain.Lotto;
import step2.domain.Money;
import step2.domain.Shop;
import step2.dto.JudgeResponse;
import step2.dto.ShopResponse;

public class LottoController {

    private final InputView inputView = new InputView();
    private final RuntimeView runtimeView = new RuntimeView();
    private final ResultView resultView = new ResultView();

    private final Shop shop = new Shop();
    private final Judge judge = new Judge();

    public void buyManualLotto() {
        Money money = inputView.getMoneyInput();
        int capacity = shop.calculateLottoCapacity(money);
        ShopResponse shopResponse = shop.buyLotto(money, capacity);
        runtimeView.printLottoAmount(shopResponse);
        runtimeView.printLottoNumbers(shopResponse);
        Lotto winningLotto = inputView.getLastWeekWiningLottoNumbers();
        JudgeResponse judgeResponse = judge.calculateResult(shopResponse, winningLotto);
        resultView.printResult(judgeResponse);
    }

}
