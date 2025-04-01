package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();

        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();

        customer.purchaseLotto(purchaseAmount, Lottos.of(InputView.getManualLottoList(manualLottoCount)));

        OutputView.printLottoList(customer.getLottos());

        WinningLotto winningLotto = new WinningLotto(ManualLotto.of(InputView.getWinningNumbers()), LottoNumber.of(InputView.getBonusNumber()));

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }


}
