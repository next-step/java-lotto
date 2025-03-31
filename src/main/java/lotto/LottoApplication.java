package lotto;

import lotto.domain.Customer;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();

        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();

        customer.purchaseLotto(purchaseAmount, InputView.getManualLottoList(manualLottoCount));

        OutputView.printLottoList(customer.getLottos());

        WinningLotto winningLotto = new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }
}
