package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;


public class LottoApplication {

    public static final int LOTTO_COST = 1000;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        // 로또 구매 금액을 입력 받는다.
        int buyingAmount = inputView.buyingAmount();

        // 수동 로또를 입력 받는다.
        int manualLottoCount = inputView.manualLottoCount();
        Lottos manualLottos = inputView.getManualLottoInput(manualLottoCount);

        // 로또를 생성한다 (수동 + 자동 리스트).
        Lottos lottos = LottoFactory.createLottos(buyingAmount, manualLottoCount, manualLottos);

        // 생성한 모든 로또를 출력한다.
        resultView.printLottos(lottos, manualLottoCount);

        // 당첨번호를 입력 받는다.
        Lotto winningNumber = inputView.stringToLotto(inputView.getWinningNoInput());

        // 보너스 번호를 입력 받는다.
        WinningLotto winningLotto = inputView.bonusNumber(winningNumber);

        // 당첨 결과를 정산한다.
        Results results = new Results();
        results.countMatchingLottos(lottos, winningLotto);

        // 수익률을 계산한다.
        Profit profit = new Profit(results, lottos);
        double profitRate = profit.getProfitRate();

        // 로또 결과를 출력한다.
        resultView.printResult(results, profitRate);
    }

}
