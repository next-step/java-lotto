package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();

        int purchaseAmount = InputView.getPurchaseAmount();
        customer.purchaseLotto(purchaseAmount);

        OutputView.printLottos(customer.getLottoList());

        Lotto winningLotto = InputView.getWinningLotto();
        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }
}
