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
        int manualLottoCount = inputView.manualLottoPurchaseCount();

        List<List<Integer>> manualLottoNumbers = inputView.getManualNumbers(manualLottoCount);

        Customer customer = new Customer(money);
        manualLottoNumbers.forEach(numbers -> customer.buy(1000, new Lotto(numbers)));
        customer.buyRemainingAutoLotto(1000);

        resultView.printLottos(customer);
        List<Integer> winningLottoNumbers = inputView.findWinningLottoNumbers();
        int bonusNumber = inputView.getBonusNumber();

        List<Rank> winningList = customer.getWinningList(new WinningNumbers(winningLottoNumbers, bonusNumber));
        resultView.printWinningList(winningList);
        resultView.printProfit(customer.profit(winningList));
    }
}
