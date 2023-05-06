package lottoauto;

import java.util.List;
import lottoauto.domain.LottoService;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningLotto;
import lottoauto.view.InputView;
import lottoauto.view.ResultView;

public class LottoAutoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int amount = inputView.inputAmount();

        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();

        Lottos lottos = lottoService.generateLottoNumber(amount);

        resultView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.inputLastWinningNumber();

        WinningLotto winningLotto = WinningLotto.of(lottos, winningNumbers);
        LottoResult lottoResult = winningLotto.compareWinningLottoNumber();

        resultView.printStatistics(lottoResult);
        resultView.printRate(lottoResult.getRate(amount));

    }
}
