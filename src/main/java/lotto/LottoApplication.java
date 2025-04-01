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

        customer.purchaseLotto(purchaseAmount, Lottos.of(InputView.getManualLottoList(manualLottoCount)));

        OutputView.printLottoList(customer.getLottos());

        List<LottoNumber> winningNumbers = LottoNumber.from(InputView.getWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.getBonusNumber());
        WinningLotto winningLotto = new WinningLotto(Lotto.generateManualLotto(winningNumbers), bonusNumber);

        LottoResult lottoResult = LottoResult.of(customer, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }


}
