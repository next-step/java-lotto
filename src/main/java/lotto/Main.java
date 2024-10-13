package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatics;
import lotto.domain.Rank;
import lotto.domain.WinNumber;
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

        WinNumber winNumber = InputView.inputWinnerNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        OutputView.staticsView();
        OutputView.matchView(Rank.THREE, lottoStatics.findRank(winNumber, Rank.THREE, bonusNumber));
        OutputView.matchView(Rank.FOUR, lottoStatics.findRank(winNumber, Rank.FOUR, bonusNumber));
        OutputView.matchView(Rank.FIVE, lottoStatics.findRank(winNumber, Rank.FIVE, bonusNumber));
        OutputView.matchView(Rank.SECOND, lottoStatics.findRank(winNumber, Rank.SECOND, bonusNumber));
        OutputView.matchView(Rank.WIN, lottoStatics.findRank(winNumber, Rank.WIN, bonusNumber));
        OutputView.ratioView(Rank.ratio(lottoStatics.totalPrize(winNumber, bonusNumber), money));
    }
}
