package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();

        int money = inputView.readMoney();
        List<Lotto> lottos = lottoService.buyLottos(money);

        resultView.printLottoCount(lottos.size());
        resultView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);

        LottoResult lottoResult = lottoService.calculateResult(lottos, winningLotto);

        resultView.printLottoResult(lottoResult);
        resultView.printProfitRate(lottoResult.calculateProfitRate(money));
    }
}
