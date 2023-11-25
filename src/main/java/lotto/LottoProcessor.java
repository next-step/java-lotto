package lotto;

import lotto.application.dto.LottoRequest;
import lotto.application.dto.LottoResponse;
import lotto.application.service.BenefitCalculator;
import lotto.domain.Lottos;
import lotto.ui.InputView;
import lotto.ui.ResultView;


public class LottoProcessor {

    public static void main(String[] args) {
        LottoRequest request = createLottoRequest();

        BenefitCalculator calculator = new BenefitCalculator();
        LottoResponse response = calculator.calculateBenefit(request);

        ResultView resultView = new ResultView();
        resultView.showResult(response);
    }

    private static LottoRequest createLottoRequest() {
        InputView inputView = new InputView();
        Integer amount = inputView.inputAmount();
        Integer manualCount = inputView.inputManualCount();
        Integer autoCount = (amount / 1000) - manualCount;
        Lottos lottos = createLottos(inputView, manualCount, autoCount);
        inputView.printLottos(manualCount, autoCount, lottos);

        return new LottoRequest(
                amount,
                lottos,
                inputView.inputWinningLotto(),
                inputView.inputBonusNumber());
    }

    private static Lottos createLottos(InputView inputView, Integer manualCount, Integer autoCount) {
        Lottos manualLottos = new Lottos(inputView.calculateManualLottos(manualCount));
        Lottos autoLottos = new Lottos(inputView.calculateAutoLottos(autoCount));

        manualLottos.addLottos(autoLottos);
        return manualLottos;
    }
}
