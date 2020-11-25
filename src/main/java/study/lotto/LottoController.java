package study.lotto;

import study.lotto.core.Lotto;
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

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private LottoDispenser lottoDispenser = LottoDispenser.getInstance();

    public void startLottoGame() {

        // 구매
        Lottos lottos = purchase();

        // 당첨 번호 및 추첨
        WinLottoNumbers winLottoNumbers = winLottoNumbers();
        Lottery lottery = new Lottery(winLottoNumbers, lottos);
        LotteryResult lotteryResult = lottery.checkLotto();
        
        // 결과 출력
        LotteryResultView.display(lotteryResult);

    }

    private Lottos purchase() {
        // 구매 수량 입력
        PurchaseAmount purchaseAmount = PurchaseInputView.display();
        // 구매 - 수동
        Lottos manualLottos = purchaseManualLottos(purchaseAmount);
        // 구매결과 출력
        PurchaseInputView.displayPurchaseAmount(purchaseAmount);
        // 구매 - 자동
        Lottos autoLottos = lottoDispenser.auto(purchaseAmount.getNumberOfAutoLotto());
        // 자동로또 출력
        LottoPurchaseResultView.display(autoLottos);
        // 병합
        return Lottos.mergeLottos(manualLottos, autoLottos);
    }

    private Lottos purchaseManualLottos(PurchaseAmount purchaseAmount) {

        List<Lotto> lottos = new ArrayList<>();

        ManualLottoInputView.displayMessage();

        for (int count = 0; count < purchaseAmount.getNumberOfManualLotto(); count++) {
            List<String> manualLottoInput = ManualLottoInputView.getInput();
            Lotto manualLotto = lottoDispenser.manual(manualLottoInput);
            lottos.add(manualLotto);
        }

        return new Lottos(lottos);
    }

    private WinLottoNumbers winLottoNumbers() {
        List<String> winLottoNumbersInput = WinNumbersInputView.getWinLottoNumbersInput();
        String bonusLottoNumberInput = WinNumbersInputView.getBonusLottoNumberInput();
        return new WinLottoNumbers.WinLottoNumbersBuilder(winLottoNumbersInput)
                .bonusLottoNumber(bonusLottoNumberInput)
                .build();
    }

}
