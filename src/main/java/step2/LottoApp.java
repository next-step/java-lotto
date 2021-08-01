package step2;

import step2.domain.LottoList;
import step2.domain.LottoMachine;
import step2.domain.LottoMarket;
import step2.strategy.RandomLottoNum;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;

public class LottoApp {
    public static void main(String[] args) {
        buyLotto();
    }

    private static void buyLotto() {
        int money = InputView.inputMoney();
        LottoList myLottoList = LottoList.create();

        LottoMarket market = new LottoMarket(LottoMachine.of(new RandomLottoNum()),
                myLottoList);
        int buyMoney = market.buy(money);

        ResultView.showList(myLottoList.getAll());

        Map<Integer,Integer> result = market.checkNumToWinner(InputView.inputWinnerNumber());

        ResultView.showResult(result,buyMoney);
    }
}
