package domain;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    static final int PRICE = 1000;

    public static void main(String[] args) {
        int totalMoney = InputView.purchasingAmount();
        int turn = totalMoney/PRICE;
        ResultView.printNumberOfLottos(turn);

        List<Lotto> lottos = LottoCreate.LottoCreate(turn);

        ResultView.printLottos(lottos);

        Lotto winning = Lotto.fromCommas(InputView.typeLottoNumbers());
        WinningLotto winningLotto = WinningLotto.from(winning, InputView.typeBonusNo());

        LottoResult lottoResult = new LottoResult();

        for(Lotto lotto : lottos) {
            lottoResult.addLotto((winningLotto.matchesNo(lotto)));
        }

        ResultView.printResult(lottoResult);
        ResultView.printProfit(lottoResult, totalMoney);
    }
}
