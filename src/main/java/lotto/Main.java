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
        int price = inputView.purchaseAmountQuestion();

        Customer customer = new Customer(price);
        for (int i = 0; i < price / 1000; i++) {
            Lotto lotto = customer.buy(1000);
            System.out.println("lotto = " + lotto);
        }

        List<Integer> prevLottoNumbers = inputView.findPrevLottoNumbers();
        List<List<Integer>> lists = customer.compareTo(prevLottoNumbers);

        ResultView resultView = new ResultView(new Revenue(lists, price));
        resultView.print();

    }
}
