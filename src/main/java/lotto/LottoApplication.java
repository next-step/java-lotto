package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();

        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();

        customer.purchaseLotto(purchaseAmount);

        OutputView.printLottoList(customer.getLottoList());

        WinningLotto winningLotto = new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }
}
