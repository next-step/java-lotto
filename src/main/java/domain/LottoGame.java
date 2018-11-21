package domain;

import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGame {
    static final int PRICE = 1_000;

    public static void main(String[] args) {
        int turn = Money.turnOfLotto(InputView.purchasingAmount());
        int manual = InputView.ManualLotto();
        List<Lotto> list = InputView.typeManualLotto(manual);
        ResultView.printNumberOfLottos(turn, manual);

        LottoCreate lottos = LottoCreate.from(turn-manual, list);

        ResultView.printLottos(lottos);

        Lotto winning = Lotto.fromCommas(InputView.typeLottoNumbers());
        WinningLotto winningLotto = WinningLotto.from(winning, InputView.typeBonusNo());

        LottoResult lottoResult = lottos.match(winningLotto);

        ResultView.printResult(lottoResult);
        ResultView.printProfit(lottoResult, turn * PRICE);
    }
}
