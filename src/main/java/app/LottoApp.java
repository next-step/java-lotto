package app;

import app.action.LottoMachine;
import app.action.LottoMarket;
import app.domain.lotto.Lotteries;
import app.domain.lotto.LottoNum;
import app.domain.Money;
import app.domain.Winning;
import app.strategy.RandomLottoNum;
import app.view.InputView;
import app.view.ResultView;

import java.util.Map;

public class LottoApp {
    public static void main(String[] args) {
        buyLotto();
    }

    private static void buyLotto() {
        Money money = InputView.inputMoney();

        if(money.getMoney() < LottoMarket.PRICE){
            ResultView.nothingToDo();
            return;
        }

        Lotteries myLottoList = Lotteries.create();

        LottoMarket market = new LottoMarket(LottoMachine.of(new RandomLottoNum()),
                myLottoList);

        Money manualCountMoney = InputView.inputManual(myLottoList, money);


        int buyMoney = market.buy(manualCountMoney);
        ResultView.showList(myLottoList.getAll(),manualCountMoney);
        LottoNum bonus = InputView.inputBonus();
        Map<Winning, Integer> result = market.checkNumToWinner(InputView.inputWinnerNumber(bonus));

        ResultView.showResult(result, buyMoney);
    }
}
