package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoMachine lottoMachine = new LottoMachine();
        ResultView resultView = new ResultView();

        int price = inputView.buyLotto();

        int count = lottoMachine.run(price);
        int manualCount = inputView.buyManualLotto();
        count = manualCount;

        List<Lotto> manualList = inputView.manualLottoNumber(manualCount);

        resultView.printCount(count, manualCount);

        List<Lotto> lottos = lottoMachine.addLottos(count, manualList);

        for (Lotto lotto: lottos) {
            resultView.lottoList(lotto);
        }

        List<Integer> correctNumbers = inputView.lastWeekendNumber();
        int bonusNumber = inputView.bonusNumber();

        for (Lotto lotto: lottos) {
            lottoMachine.lotteryJackpot(lotto, correctNumbers, bonusNumber);
        }
        Map<Rank, Integer> result = lottoMachine.lotteryRewards();

        resultView.printResult(result, price);
    }
}
