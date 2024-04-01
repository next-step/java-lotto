package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.Ranks;
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
        Set<Integer> winningNo = inputView.winningNo(inputView.getWinningNoInput());

        // 당첨 결과를 정산한다.
        Ranks ranks = new Ranks();
        ranks.countMatchingLottos(lottos, winningNo);

        // 수익률을 계산한다.
        Profit profit = new Profit(ranks, lottos);
        double profitRate = profit.getProfitRate();

        // 로또 결과를 출력한다.
        resultView.printResult(ranks, profitRate);
    }

}
