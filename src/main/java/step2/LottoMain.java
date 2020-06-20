package step2;

import step2.model.*;
import step2.util.LottoMakeNumbers;
import step2.view.LottoInput;
import step2.view.LottoOutput;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int lottoMoney = LottoInput.inputGameMoney();
        List<Lotto> LottoList = LottoInput.inputInputSelfPurchase();

        LottoGame lottoGame = new LottoGame(new LottoMoney(lottoMoney), Lottos.of(LottoList));

        LottoOutput.printPurchaseNumbers(lottoGame.getLottoRandomCount(), lottoGame.getLottoSelfCount());
        LottoOutput.printLottoNumbers(lottoGame);

        LottoTotalCalculator lottoTotalCalculator = LottoTotalCalculator.of(
                lottoGame.getLottos()
                , LottoWinning.of(
                        Lotto.of(
                                LottoMakeNumbers.convertStringToNumbers(
                                        LottoInput.inputWinnerNumbers()
                                )
                        )
                        , LottoInput.inputBonus()
                )
        );

        LottoOutput.printWinningStatistics(lottoTotalCalculator);
    }
}
