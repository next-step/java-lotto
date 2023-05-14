package lotto.step4;

import lotto.step4.domain.*;
import lotto.step4.enums.Rank;
import lotto.step4.view.InputView;
import lotto.step4.view.ResultView;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        LottoCount lottoCount = inputView.inputPrice();
        ManualLotto manualLotto = inputView.inputManualLotto();
        LottoStrategy lottoStrategy = new LottoAutoStrategy();
        Lottos lottos = new Lottos(lottoStrategy, lottoCount, manualLotto);
        ResultView.printLottos(lottos);

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();

        Result result = winningNumbers.getWinnerStat(lottos);
        ResultView.printWinnerStat(result, Rank.getTotalReturnResult(result, lottoCount.getPrice()));
    }
}
