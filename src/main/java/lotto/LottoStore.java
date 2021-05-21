package lotto;

import lotto.domain.LottoMachine;
import lotto.dto.AnalysisSheet;
import lotto.dto.OrderSheet;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoStore {

  public static void main(String[] args) {
    OrderSheet orderSheet = InputView.orderNewGames();
    LottoMachine lottoMachine = new LottoMachine(orderSheet);
    OutputView.displayOrderedGames(lottoMachine.peekOrderedGames());
    AnalysisSheet analysisSheet = lottoMachine.confirmPrizeOrderedLottos(InputView.inputWinningNumbers());
    OutputView.displayAnalysisSheet(analysisSheet);
  }
}
