package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Lotto;
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
        resultView.printCount(count);

        List<Lotto> lottos = lottoMachine.addLottos(count);

        for (Lotto lotto: lottos) {
            resultView.lottoList(lotto);
        }

        List<Integer> correctNumbers = inputView.lastWeekendNumber();

        for (Lotto lotto: lottos) {
            lottoMachine.lotteryJackpot(lotto, correctNumbers);
        }
        Map<String, Object> result = lottoMachine.lotteryRewards();

        resultView.printResult(result, price);
    }
}
