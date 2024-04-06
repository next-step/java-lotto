package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Set;

public class LottoApplication {

    public static final int LOTTO_COST = 1000;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        // 로또 구매 금액을 입력받는다.
        int buyingAmount = inputView.buyingAmount(inputView.getBuyingAmountInput());

        // 로또를 생성한다.
        Lottos lottos = LottoFactory.createLottos(buyingAmount);
        resultView.printLottos(lottos);

        // 당첨번호를 입력받는다.
        Lotto winningLotto = inputView.winningNo(inputView.getWinningNoInput());

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
