package lotto.step3;

import lotto.step3.domain.*;
import lotto.step3.enums.Rank;
import lotto.step3.view.InputView;
import lotto.step3.view.ResultView;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        LottoCount lottoCount = inputView.inputInitData();
        LottoStrategy lottoStrategy = new LottoAutoStrategy();
        Lottos lottos = new Lottos(lottoStrategy, lottoCount);
        ResultView.printLottos(lottos);

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();

        Result result = winningNumbers.getWinnerStat(lottos);
        ResultView.printWinnerStat(result, Rank.getTotalReturnResult(result, lottoCount.getPrice()));
    }
}
