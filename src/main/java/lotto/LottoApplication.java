package lotto;

import lotto.domain.Customer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.purchaseLottos(InputView.getPurchaseAmount());

        OutputView.printLottos(customer.getLottos());

        customer.checkLottosResult(InputView.getWinningNumbers());
//        OutputView.printStatistics(lottos.getStatistics());

        OutputView.printROI(customer.calculateROI());
    }
}
