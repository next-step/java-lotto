package step2;

import step2.domain.WinningNumber;
import step2.domain.PurchaseNumbers;
import step2.service.LottoGame;
import step2.domain.LottoResult;
import step2.view.InputView;
import step2.view.PrintView;

import java.util.List;

public class Lotto {

    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();
        int manualLottoCount = InputView.manualLottoCount();
        List<List<Integer>> manualLottoNumber = InputView.manualLottoNumber(manualLottoCount);

        LottoGame lottoGame = LottoGame.readyGame(purchaseAmount, manualLottoCount);
        PurchaseNumbers purchaseNumbers = PurchaseNumbers.generate(lottoGame.generateLotto(manualLottoNumber));
        PrintView.purchaseNumber(purchaseNumbers.purchaseNumbers());

        List<Integer> winningNumber = InputView.winningNumber();
        int bonusNumber = InputView.bonusNumber();
        WinningNumber lottoNumber = WinningNumber.generate(winningNumber, bonusNumber);

        LottoResult result  = lottoGame.lottoResult(purchaseNumbers, lottoNumber);
        PrintView.lottoResult(result);
    }
}
