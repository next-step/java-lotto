package lotto;

import lotto.application.dto.LottoRequest;
import lotto.application.dto.LottoResponse;
import lotto.application.service.BenefitCalculator;
import lotto.common.handler.UiExceptionHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import java.util.List;

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
        int amount = inputView.inputAmount();
        int manualCount = inputView.inputManualCount();
        int autoCount = UiExceptionHandler.calculateAutoCount(amount, manualCount);
        Lottos lottos = createLottos(inputView, manualCount, autoCount);
        inputView.printLottos(manualCount, autoCount, lottos);

        return new LottoRequest(
                amount,
                lottos,
                inputView.inputWinningLotto(),
                LottoNumber.valueOf(inputView.inputBonusNumber()));
    }

    private static Lottos createLottos(InputView inputView, int manualCount, int autoCount) {
        List<Lotto> manualLottoList = inputView.calculateManualLottos(manualCount);
        if (autoCount > 0) {
            List<Lotto> autoLottoList = inputView.calculateAutoLottos(autoCount);
            manualLottoList.addAll(autoLottoList);
        }
        return new Lottos(manualLottoList);
    }
}
