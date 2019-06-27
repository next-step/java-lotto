package lotto;

import lotto.model.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoRunner {

  public static void main(String[] args) {

    Money paidMoney = LottoInputView.askPurchaseAmount();
    Quantity quantity = LottoInputView.askManualPurchaseQuantity(paidMoney);
    List<List<LottoNumber>> lottoNumbers = LottoInputView.askLottoNumbersToBuyManually(quantity);

    Lottos manualLottos = LottoGenerator.generateManually(lottoNumbers);
    paidMoney.makePayment(quantity);

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
    Lottos autoLottos = lottoGenerator.generate(paidMoney);
    Lottos lottos = lottoGenerator.union(manualLottos, autoLottos);

    LottoOutputView.printCountOf(manualLottos, autoLottos);
    LottoOutputView.printPickedNumbersOf(lottos);

    Lotto lottoWithWinningNumbers = LottoInputView.askWinningNumbers();
    LottoNumber bonusNumber = LottoInputView.askBonusNumber();
    WinningLotto winningLotto = new WinningLotto(lottoWithWinningNumbers, bonusNumber);

    Analyzer analyzer = new Analyzer(winningLotto);
    Report report = analyzer.analyze(lottos);

    LottoOutputView.print(report);
  }
}
