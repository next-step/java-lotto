package lotto;

import lotto.application.dto.LottoRequest;
import lotto.application.dto.LottoResponse;
import lotto.application.service.BenefitCalculator;
import lotto.domain.Lottos;
import lotto.ui.InputView;
import lotto.ui.ResultView;


public class LottoProcessor {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Integer amount = inputView.inputAmount();
        Lottos lottos = new Lottos(inputView.calculateLottos(amount));
        LottoRequest request = new LottoRequest(
                amount,
                lottos,
                inputView.inputWinningLotto(),
                inputView.inputBonusNumber());

        BenefitCalculator calculator = new BenefitCalculator();
        LottoResponse response = calculator.calculateBenefit(request);

        ResultView resultView = new ResultView();
        resultView.showResult(response);
    }
}
