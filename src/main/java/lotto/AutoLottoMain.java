package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class AutoLottoMain {
    public static void main(String[] args) {

        // 로또 구매 금액 입력받기
        int amount = InputView.scanAmount();

        // 수동로또 입력받기
        int manualLottoCount = InputView.scanManualCount();
        Lottos manualLottos = InputView.scanManualNumbers(manualLottoCount);

        // 수동 및 자동 로또 구매하기
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount, manualLottos);
        Lottos issuedLottos = new Lottos(lottos);
        OutputView.printBuyLottos(lottos);

        // 당첨번호 확인하기
        List<Integer> winNumbers = InputView.scanWinningNumbers();
        Lotto winner = new Lotto(winNumbers);
        int bonusNumber = InputView.scanBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winner, bonusNumber);

        // 당첨 결과 확인하기
        LottoResult lottoResult = issuedLottos.winningResult(winningLotto);
        OutputView.printWinningStatic(lottoResult);
        OutputView.printReturnRate(lottoResult.returnRate(amount));
    }
}
