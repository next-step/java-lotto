package lotto;

import java.util.List;

import lotto.view.InputView;
import lotto.view.MatchNumberView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int money = InputView.inputAmount();

        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(1, 45));
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
        OutputView.matchView(MatchNumberView.THREE, lottoStatics.match(winNumber, 3));
        OutputView.matchView(MatchNumberView.FOUR, lottoStatics.match(winNumber, 4));
        OutputView.matchView(MatchNumberView.FIVE, lottoStatics.match(winNumber, 5));
        OutputView.matchView(MatchNumberView.SIX, lottoStatics.match(winNumber, 6));
        OutputView.ratioView(lottoStatics.calculateRatio(winNumber, money));
    }
}
