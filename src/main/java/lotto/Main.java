package lotto;

import lotto.contoller.InputView;
import lotto.contoller.ResultView;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Revenue;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.purchaseAmountQuestion();
        Customer customer = new Customer(money);

        List<Lotto> lottos = customer.buy(1000);
        resultView.printLottos(lottos);



        List<Integer> winningLottoNumbers = inputView.findPrevLottoNumbers();
        List<List<Integer>> lists = customer.compareTo(winningLottoNumbers);

//        ResultView resultView = new ResultView(new Revenue(lists, price));
        resultView.print(customer);

    }
}
