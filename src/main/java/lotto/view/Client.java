package lotto.view;

import lotto.Bag;
import lotto.Lotto;
import lotto.Money;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.setMoney(); // 로또를 구매할 돈을 받는다
        inputView.setWinNumbers(); // 당첨번호를 입력 받는다

        Bag bag = new Bag(inputView.getMoney());
        bag.buyLotto(new Money(1000));

        ResultView resultView = new ResultView(inputView.getMoney(), new Lotto(inputView.getWinNumbers()));
        resultView.showStatistics(bag); // 로또 결과를 알려준다.
        resultView.showYield(bag); // 수익률을 알려준다.
    }
}
