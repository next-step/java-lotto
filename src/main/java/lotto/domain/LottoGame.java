package lotto.domain;

import lotto.domain.generator.ManualLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        List<Lotto> lottos;
        Money money = new Money(InputView.inputCost());

        int manualLottoCount = InputView.inputManualLottoCount();
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(InputView.inputManualLottos(manualLottoCount));
        lottos = manualLottoGenerator.generate(money);


        ResultView.moveLine();
        ResultView.showLottoCount(money, manualLottoCount);
        ResultView.showLottos(lottos);
        ResultView.moveLine();

        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningLotto(), InputView.inputWinningBonus());

        LottoResultDefault result = new LottoResultDefault();
        for(Lotto lotto : lottos) {
            result.setRankingStatus(winningLotto.getRankByMatchingLotto(lotto));
        }

        ResultView.moveLine();
        ResultView.showStatistics(result, money.profitRate(result.getTotalPrize()));
    }

}
