package lotto;

import lotto.domain.*;
import lotto.dto.MatchRankDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String args[]) {
        LottoGame lottoGame = new LottoGame(new PurchaseAmount(InputView.getPurchaseAmount()));
        OutputView.printPurchaseLotto(lottoGame.getLottoAmount());
        OutputView.printLottoNumbers(lottoGame.getLottoNumbers());

        String winningNumbersText = InputView.getWinningNumbers();
        String bonusNumberText = InputView.getBonusNumber();
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbersText);
        LottoNumber bonusLottoNumber = new LottoNumber(new NumberText(bonusNumberText));
        lottoGame.confirmLottos(winningLottoNumbers, bonusLottoNumber);

        OutputView.printWinningResult(MatchRankDto.from(lottoGame));
    }
}
