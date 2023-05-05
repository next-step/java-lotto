package step2.main;

import step2.domain.vo.LottoPrize;
import step2.domain.vo.Money;
import step2.service.LottosIssuance;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final var money = InputView.inputMoney();
        final var lottos = LottosIssuance.issues(new Money(money));

        OutputView.printLottoks(lottos);

        final var lastLottoNumbers = InputView.inputLastLottoNumbers();
        final var bonusBall = InputView.inputBonusLottoNumber();
        List<LottoPrize> lottoPrizes = lottos.checkLottoPrize(lastLottoNumbers, bonusBall);

        OutputView.printWinnerStatistics(lottos, lottoPrizes);
    }
}
