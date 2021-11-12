package lotto.view;

import lotto.Bag;
import lotto.Lotto;
import lotto.Money;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.setMoney();
        inputView.setWinNumbers();

        Bag bag = new Bag(inputView.getMoney());
        bag.buyLotto(new Money(1000));


        ResultView resultView = new ResultView(inputView.getMoney(), new Lotto(inputView.getWinNumbers()));
        resultView.showStatistics(bag);
        resultView.showYield(bag);
    }
}
