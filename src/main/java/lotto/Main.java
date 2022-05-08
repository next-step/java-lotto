package lotto;

import lotto.contoller.InputView;
import lotto.contoller.ResultView;
import lotto.domain.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.purchaseAmountQuestion();
        Customer customer = new Customer(money);
        customer.buy(1000);

        resultView.printLottos(customer);
        List<Integer> winningLottoNumbers = inputView.findWinningLottoNumbers();

        List<Rank> winningList = customer.getWinningList(winningLottoNumbers);
        resultView.printWinningList(winningList);
        resultView.printProfit(customer.profit(winningList));
    }
}
