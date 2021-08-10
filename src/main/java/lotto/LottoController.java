package lotto;

import lotto.domain.*;
import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public final class LottoController {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            ResultView resultView = new ResultView();
            LottoMachine lottoMachine = new LottoMachine();

            Lottos lottos = lottoMachine.buyLotto(inputView.inputAmount(), new AutoPurchaseStrategy());
            int totalCount = lottos.count();

            resultView.printLottoCount(totalCount);
            resultView.printLottos(lottos);

            Lotto winningLotto = new Lotto(inputView.inputWinningNumbers());
            LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());

            WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, bonusNumber);
            List<Result> results = winningsStatistics.makeStatisticsWinnings(lottos);
            double earningsRate = winningsStatistics.calculateEarningsRate(results, totalCount);

            resultView.printStatistics(results);
            resultView.printEarningsRate(earningsRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
