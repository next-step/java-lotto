package lotto;

import lotto.domain.Customer;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.purchaseLottos(InputView.getPurchaseAmount());

        OutputView.printLottos(customer.getLottos());

        Lottos lottos = customer.getLottos();
        lottos.determineAllLottoResult(InputView.getWinningNumbers());
        OutputView.printStatistics(lottos.getStatistics());

        OutputView.printROI(customer.calculateROI());
    }
}
