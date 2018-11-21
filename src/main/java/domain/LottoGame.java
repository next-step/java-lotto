package domain;

import view.InputView;
import view.ResultView;

public class LottoGame {
    static final int PRICE = 1_000;

    public static void main(String[] args) {
        int turn = Money.turnOfLotto(InputView.purchasingAmount());
        ResultView.printNumberOfLottos(turn);

        LottoCreate lottos = LottoCreate.from(turn);

        ResultView.printLottos(lottos);

        Lotto winning = Lotto.fromCommas(InputView.typeLottoNumbers());
        WinningLotto winningLotto = WinningLotto.from(winning, InputView.typeBonusNo());

        LottoResult lottoResult = lottos.match(winningLotto);

        ResultView.printResult(lottoResult);
        ResultView.printProfit(lottoResult, turn * PRICE);
    }
}
