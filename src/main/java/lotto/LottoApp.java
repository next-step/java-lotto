package lotto;

import lotto.strategy.RandomLottoNum;
import lotto.domain.Lotteries;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMarket;
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
        int bonus = InputView.inputBonus();
        Map<Winning,Integer> result = market.checkNumToWinner(InputView.inputWinnerNumber(), bonus);

        ResultView.showResult(result, buyMoney);
    }
}
