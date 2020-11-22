package study.lotto;

import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.dispenser.Lottos;
import study.lotto.lottery.Lottery;
import study.lotto.lottery.LotteryResult;
import study.lotto.view.input.ManualLottoInputView;
import study.lotto.view.input.PurchaseInputView;
import study.lotto.view.input.WinNumbersInputView;
import study.lotto.view.result.LotteryResultView;
import study.lotto.view.result.LottoPurchaseResultView;

public class LottoController {

    public void purchaseByAuto() {

        // 구매
        Lottos lottos = purchaseLottos();

        // 당첨 번호 및 추첨
        WinLottoNumbers winLottoNumbers = WinNumbersInputView.display();
        Lottery lottery = new Lottery(winLottoNumbers, lottos);
        LotteryResult lotteryResult = lottery.checkLotto();
        
        // 결과 출력
        LotteryResultView.display(lotteryResult);

    }

    private Lottos purchaseLottos() {
        // 구매 수량 입력
        PurchaseAmount purchaseAmount = PurchaseInputView.display();
        // 구매 - 수동
        Lottos manualLottos = ManualLottoInputView.display(purchaseAmount.getNumberOfManualLotto());
        // 구매결과 출력
        PurchaseInputView.displayPurchaseAmount(purchaseAmount);
        // 구매 - 자동
        Lottos autoLottos = LottoDispenser.auto(purchaseAmount.getNumberOfAutoLotto());
        // 자동로또 출력
        LottoPurchaseResultView.display(autoLottos);
        // 병합
        return Lottos.mergeLottos(manualLottos, autoLottos);
    }

}
