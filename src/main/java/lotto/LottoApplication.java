package lotto;

import lotto.application.LottoService;
import lotto.domain.NumberGenerator;
import lotto.infra.ManualNumberGenerator;
import lotto.infra.RandomNumberGenerator;
import lotto.presentation.InputView;
import lotto.presentation.LottoController;
import lotto.presentation.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        ManualNumberGenerator manualNumberGenerator = new ManualNumberGenerator();
        LottoService lottoService = new LottoService(numberGenerator, manualNumberGenerator);
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LottoController lottoController = new LottoController(lottoService, inputView, resultView);

        lottoController.startLotto();
    }
}
