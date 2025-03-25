package lotto;

import lotto.domain.Customer;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.purchaseLottos(InputView.getPurchaseAmount());

        OutputView.printLottos(customer.getLottos());

        List<Integer> winningNumbers = InputView.getWinningNumbers();

        Lottos lottos = customer.getLottos();
        lottos.checkAllLottosResult(winningNumbers);
        OutputView.printStatistics(lottos.getStatistics());

        OutputView.printROI(customer.calculateROI());
    }
}
