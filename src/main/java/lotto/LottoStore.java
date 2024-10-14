package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStore {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    public void buy() {
        int lottoAmount = inputView.receivePurchasingAmount();
        Lottos lottos = lottoGenerator.getLottos(lottoAmount);
        resultView.printLottoResult(lottos);

        WinningNumber winningNumber = new WinningNumber(inputView.receiveWinningNumber());
        LottoNumber bonusNo = inputView.receiveBonusNo();
        System.out.println("보너스 번호는 " + bonusNo + "입니다.");
        lottos.calculateLotto(winningNumber);
        resultView.printLottoStatistics(lottos, inputView.getPurchasingAmount());
    }
}
