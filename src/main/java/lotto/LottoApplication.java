package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();

        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();

        customer.purchaseLotto(purchaseAmount, InputView.getManualLottoList(manualLottoCount));

        OutputView.printLottoList(customer.getLottoList());

        WinningLotto winningLotto = new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }
}
