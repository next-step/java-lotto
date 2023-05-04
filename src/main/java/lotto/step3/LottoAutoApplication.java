package lotto.step3;

import lotto.step3.domain.*;
import lotto.step3.enums.MatchNumber;
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
        BonusNumber bonusNumber = inputView.inputBonusNumber(winningNumbers);


        Result result = new Result(winningNumbers.getWinnerStat(lottos, bonusNumber.getBonusNumber()));
        ResultView.printWinnerStat(result, MatchNumber.getTotalReturnResult(result, lottoCount.getPrice()));
    }
}
