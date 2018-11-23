package domain;

import view.InputView;
import view.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        int total = InputView.purchasingAmount();
        int manual = InputView.ManualLotto();

        Money money = Money.amountOfPurchase(total, manual);
        LottoCreate lottos = LottoCreate.from();

        InputView.typeManualLotto(lottos, money);
        ResultView.printNumberOfLottos(money.turnOfLotto(), manual);

        ResultView.printLottos(lottos.generate(money));

        Lotto winning = Lotto.fromCommas(InputView.typeLottoNumbers());
        WinningLotto winningLotto = WinningLotto.from(winning, InputView.typeBonusNo());

        LottoResult lottoResult = lottos.match(winningLotto);

        ResultView.printResult(lottoResult);
        ResultView.printProfit(lottoResult, total);
    }
}