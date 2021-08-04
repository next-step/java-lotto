package lotto;

import lotto.domain.LottoNum;
import lotto.strategy.RandomLottoNum;
import lotto.domain.Lotteries;
import lotto.action.LottoMachine;
import lotto.action.LottoMarket;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoApp {
    public static void main(String[] args) {
        buyLotto();
    }

    private static void buyLotto() {
        int money = InputView.inputMoney();
        Lotteries myLottoList = Lotteries.create();

        LottoMarket market = new LottoMarket(LottoMachine.of(new RandomLottoNum()),
                myLottoList);
        int buyMoney = market.buy(money);

        ResultView.showList(myLottoList.getAll());
        LottoNum bonus = InputView.inputBonus();
        Map<Winning,Integer> result = market.checkNumToWinner(InputView.inputWinnerNumber(), bonus);

        ResultView.showResult(result, buyMoney);
    }
}
