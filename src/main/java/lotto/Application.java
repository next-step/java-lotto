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

        String winningNumbers = InputView.getWinningNumbers();
        String bonusNumber = InputView.getBonusNumber();
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);
        lottoGame.confirmLottos(winningLottoNumbers, new LottoNumber(new NumberText(bonusNumber)));

        OutputView.printWinningResult(MatchRankDto.from(lottoGame));
    }
}
