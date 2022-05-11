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
        int autoLottoCount = inputView.autoLottoPurchaseCount();

        List<List<Integer>> autoLottoNumbers = inputView.getAutoNumbers(autoLottoCount);

        Customer customer = new Customer(money);
        autoLottoNumbers.forEach(numbers -> customer.buy(1000, new Lotto(numbers)));
        customer.allBuy(1000);

        resultView.printLottos(customer);
        List<Integer> winningLottoNumbers = inputView.findWinningLottoNumbers();
        int bonusNumber = inputView.getBonusNumber();

        List<Rank> winningList = customer.getWinningList(new WinningNumbers(winningLottoNumbers, bonusNumber));
        resultView.printWinningList(winningList);
        resultView.printProfit(customer.profit(winningList));
    }
}
