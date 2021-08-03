package step3;

import step3.domain.Lotteries;
import step3.domain.LottoMachine;
import step3.domain.LottoMarket;
import step3.domain.Winnings;
import step3.strategy.RandomLottoNum;
import step3.view.InputView;
import step3.view.ResultView;

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

        Map<Winnings,Integer> result = market.checkNumToWinner(InputView.inputWinnerNumber());

        ResultView.showResult(result, buyMoney);
    }
}
