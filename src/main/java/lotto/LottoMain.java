package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int requestPurchaseAmount = inputView.requestPurchaseAmount();
        int requestManuallyPurchaseCount = inputView.requestManuallyPurchaseCount();
        LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(requestPurchaseAmount, requestManuallyPurchaseCount);

        ManuallyCreatedLottos manuallyCreatedLottos = new ManuallyCreatedLottos(inputView.requestManuallyPurchaseNumbers(requestManuallyPurchaseCount));
        resultView.showPurchaseCount(lottoPurchaseCount.getRequestManuallyPurchaseCount(), lottoPurchaseCount.getAutomaticallyPurchaseCount());

        RandomLottoCreationStrategy randomLottoCreationStrategy = new RandomLottoCreationStrategy(); // 자동 전략 설정
        Lottos lottos = new Lottos(lottoPurchaseCount.getAutomaticallyPurchaseCount(), randomLottoCreationStrategy, manuallyCreatedLottos);
        List<Lotto> createdLottos = lottos.getCreatedLottos(); // 로또 리스트 만들기

        resultView.showLottos(createdLottos); // 만들어진 로또 산출

        WinningLotto winningLotto = new WinningLotto(Lotto.createFromWinningNumbers(inputView.requestWinningNumbers()), new LottoNumber(inputView.requestBonusNumber())); // 당첨 번호, 보너스 번호 입력
        resultView.showResults(lottos.judge(createdLottos, winningLotto)); // 당첨 결과 산출
    }
}
