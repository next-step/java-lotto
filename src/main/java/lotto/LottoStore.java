package lotto;

import lotto.domain.GameGenerator;
import lotto.domain.LottoMachine;
import lotto.domain.strategy.FixedPoolRandomNumberGenerateStrategy;
import lotto.dto.AnalysisSheet;
import lotto.dto.OrderSheet;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoStore {

  public static void main(String[] args) {
    OrderSheet orderSheet = InputView.orderNewGames();
    LottoMachine lottoMachine = new LottoMachine(new GameGenerator(orderSheet, new FixedPoolRandomNumberGenerateStrategy()));
    OutputView.displayOrderedGames(lottoMachine.peekOrderedGames());
    AnalysisSheet analysisSheet = lottoMachine.confirmPrizeOrderedLottos(InputView.inputWinningNumbersAndBonusNumber());
    OutputView.displayAnalysisSheet(analysisSheet);
  }
}
