package step2;

import step2.model.*;
import step2.util.LottoMakeNumbers;
import step2.view.LottoInput;
import step2.view.LottoOutput;

public class LottoMain {

    public static void main(String[] args) {
        int lottoMoney = LottoInput.inputGameMoney();
        LottoGame lottoGame = new LottoGame(new LottoMoney(lottoMoney));

        LottoOutput.printPurchaseNumbers(lottoGame.getLottoCount());
        LottoOutput.printLottoNumbers(lottoGame);

        LottoTotalCalculator lottoTotalCalculator = LottoTotalCalculator.of(
            lottoGame.getLottos(),
            LottoWinning.of(
                Lotto.of(
                    LottoMakeNumbers.convertStringToNumbers(
                        LottoInput.inputWinnerNumbers()
                    )
                )
            )
        );

        LottoOutput.printWinningStatistics(lottoTotalCalculator);
    }
}