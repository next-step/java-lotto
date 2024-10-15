package lotto;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatics;
import lotto.domain.Rank;
import lotto.domain.WinNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {

        int money = InputView.inputAmount();
        int manualCount = InputView.manualAmount();
        List<LottoNumbers> lottoNumbers = InputView.inputManualNumbers(manualCount);

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
        winNumber.addBonus(InputView.inputBonusNumber());

        OutputView.staticsView();
        OutputView.matchView(Rank.THREE, lottoStatics.findRank(winNumber, Rank.THREE));
        OutputView.matchView(Rank.FOUR, lottoStatics.findRank(winNumber, Rank.FOUR));
        OutputView.matchView(Rank.FIVE, lottoStatics.findRank(winNumber, Rank.FIVE));
        OutputView.matchView(Rank.SECOND, lottoStatics.findRank(winNumber, Rank.SECOND));
        OutputView.matchView(Rank.WIN, lottoStatics.findRank(winNumber, Rank.WIN));
        OutputView.ratioView(Rank.ratio(lottoStatics.totalPrize(winNumber), money));
    }
}
