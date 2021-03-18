package lotto.domain;

import lotto.common.LottoConstants;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Lotto {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start(){
        int money = inputView.money();
        int buyCount = buyCount(money);
        resultView.print(buyCount);


    }

    public int buyCount(int buyMoney) {
        return buyMoney / LottoConstants.LOTTO_PRICE;
    }



}
