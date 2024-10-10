package lotto;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStatics;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int money = InputView.inputAmount();

        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = lottoMachine.lottoCount(money);
        OutputView.lottoCount(lottoCount);

        LottoStatics lottoStatics = new LottoStatics();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoMachine.generateLotto();
            lottoStatics.add(lotto);
            OutputView.lottoView(lotto);
        }

        List<Integer> winNumber = InputView.inputWinnerNumber();

        OutputView.staticsView();
        OutputView.matchView(Rank.THREE, lottoStatics.matchCount(winNumber, Rank.THREE));
        OutputView.matchView(Rank.FOUR, lottoStatics.matchCount(winNumber, Rank.FOUR));
        OutputView.matchView(Rank.FIVE, lottoStatics.matchCount(winNumber, Rank.FIVE));
        OutputView.matchView(Rank.WIN, lottoStatics.matchCount(winNumber, Rank.WIN));
        OutputView.ratioView(Rank.ratio(lottoStatics.totalPrize(winNumber), money));
    }
}
