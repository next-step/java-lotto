package lotto;

import lotto.domain.*;
import lotto.dto.MatchRankDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String args[]) {
        LottoGame lottoGame = new LottoGame(new PurchaseAmount(InputView.getPurchaseAmount()), createLottoNumbers(InputView.getManualLottoCount()));
        OutputView.printPurchaseLotto(lottoGame.getPurchaseCount());
        OutputView.printLottoNumbers(lottoGame.getLottoNumbers());

        String winningNumbersText = InputView.getWinningNumbers();
        String bonusNumberText = InputView.getBonusNumber();
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbersText);
        LottoNumber bonusLottoNumber = new LottoNumber(new IntNumber(bonusNumberText));
        lottoGame.confirmLottos(winningLottoNumbers, bonusLottoNumber);

        OutputView.printWinningResult(MatchRankDto.from(lottoGame));
    }

    private static List<LottoNumbers> createLottoNumbers(int manualLottoCount) {
        OutputView.printManualLottoNumbers();
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int  i = 0; i < manualLottoCount; i++) {
            lottoNumbers.add(new LottoNumbers(InputView.getManualLottoNumbers()));
        }
        return lottoNumbers;
    }
}
