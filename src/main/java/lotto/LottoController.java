package lotto;

import lotto.domain.*;
import lotto.domain.generationStrategy.AutoNumberGenerationStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public final class LottoController {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            ResultView resultView = new ResultView();
            LottoMachine lottoMachine = new LottoMachine();

            Lottos lottos = lottoMachine.buyLotto(inputView.inputAmount(), new AutoNumberGenerationStrategy());
            int totalCount = lottos.count();

            resultView.printLottoCount(totalCount);
            resultView.printLottos(lottos);

            Lotto winningLotto = new Lotto(inputView.inputWinningNumbers());
            LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());

            WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, bonusNumber);
            Result result = winningsStatistics.makeStatisticsWinnings(lottos);

            resultView.printStatistics(result);
            resultView.printEarningsRate(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
