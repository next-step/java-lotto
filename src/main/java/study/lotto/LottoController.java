package study.lotto;

import study.lotto.core.Lotto;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.dispenser.Lottos;
import study.lotto.lottery.Lottery;
import study.lotto.lottery.LotteryResult;
import study.lotto.view.input.PurchaseInputView;
import study.lotto.view.input.WinNumbersInputView;
import study.lotto.view.result.LotteryResultView;
import study.lotto.view.result.LottoPurchaseResultView;

import java.util.List;

public class LottoController {

    private PurchaseInputView purchaseInputView = PurchaseInputView.getInstance();
    private WinNumbersInputView winNumbersInputView = WinNumbersInputView.getInstance();
    private LottoPurchaseResultView lottoPurchaseResultView = LottoPurchaseResultView.getInstance();
    private LotteryResultView lotteryResultView = LotteryResultView.getInstance();

    private LottoDispenser lottoDispenser = LottoDispenser.getInstance();

    public void purchaseByAuto() {

        // 구매
        PurchaseAmount purchaseAmount = purchaseInputView.display();
        Lottos lottos = lottoDispenser.auto(purchaseAmount.numberOfPurchases());
        
        // 구매한 로또 출력 
        lottoPurchaseResultView.display(lottos);
        
        // 당첨 번호 및 추첨
        WinLottoNumbers winLottoNumbers = winNumbersInputView.display();
        Lottery lottery = new Lottery(winLottoNumbers, lottos);
        LotteryResult lotteryResult = lottery.checkLotto();
        
        // 결과 출력
        lotteryResultView.display(lotteryResult);

    }


}
