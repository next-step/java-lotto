package lotto;

import static lotto.Lotto.LOTTO_PRICE;
import static util.LottoInputView.insertBonusNumber;
import static util.LottoInputView.insertManualLotto;
import static util.LottoInputView.insertManualPurchaseAmount;
import static util.LottoInputView.insertPaymentAmount;
import static util.LottoInputView.insertWinningLotto;
import static util.LottoOutputView.print;
import static util.LottoOutputView.printDescriptionForInsertManualLotto;
import static util.LottoOutputView.printLottoList;
import static util.LottoOutputView.printManualPurchaseDone;
import static util.LottoOutputView.printResult;

import java.util.LinkedList;
import java.util.List;

public class LottoController {

  public void start() {
    try {
      proceed();
    } catch (Exception e) {
      print(e.getMessage());
      throw e;
    }
  }

  private void proceed() {
    Credit credit = insertPaymentAmount();
    int manualPurchaseAmount = insertManualPurchaseAmount();
    int autoPurchaseAmount = credit.calculatePurchaseAmount(LOTTO_PRICE);
    List<Lotto> manualLottoList = purchaseManualLotto(credit, manualPurchaseAmount);
    printManualPurchaseDone(manualPurchaseAmount, autoPurchaseAmount);

    LottoList lottoList = LottoList.createWithManualLottoList(manualLottoList, autoPurchaseAmount);
    printLottoList(lottoList);

    WinningLotto winningLotto = new WinningLotto(
        Lotto.create(insertWinningLotto()),
        new LottoNumber(insertBonusNumber())
    );

    printResult(lottoList, winningLotto);
  }

  private List<Lotto> purchaseManualLotto(Credit credit, int manualPurchaseAmount) {
    List<Lotto> manualLottoList = new LinkedList<>();
    printDescriptionForInsertManualLotto();
    for (int i = 0; i < manualPurchaseAmount; i++) {
      manualLottoList.add(Lotto.create(insertManualLotto()));
      credit.purchase(LOTTO_PRICE);
    }

    return manualLottoList;
  }

  public static LottoController init() {
    return new LottoController();
  }
}
