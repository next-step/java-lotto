package lotto;

import static util.LottoInputView.insertBonusNumber;
import static util.LottoInputView.insertPaymentAmount;
import static util.LottoInputView.insertWinningLotto;
import static util.LottoOutputView.printLottoList;
import static util.LottoOutputView.printPurchaseAmount;
import static util.LottoOutputView.printResult;
import static util.LottoOutputView.printResultInfo;

public class LottoController {

  public void proceed() {
    LottoList lottoList = new LottoList(insertPaymentAmount());

    printPurchaseAmount(lottoList);
    printLottoList(lottoList);

    WinningLotto winningLotto = new WinningLotto(
        Lotto.create(insertWinningLotto()),
        new LottoNumber(insertBonusNumber())
    );

    printResultInfo();
    printResult(lottoList, winningLotto);
  }

  public static LottoController init() {
    return new LottoController();
  }
}
