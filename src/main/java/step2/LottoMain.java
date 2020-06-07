package step2;

import step2.model.Lotto;
import step2.model.LottoGame;
import step2.model.LottoTotalCalculator;
import step2.model.WinnerTier;
import step2.view.LottoInput;
import step2.view.LottoOutput;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        int lottoMoney = LottoInput.inputGameMoney();

        LottoGame lottoGame = new LottoGame(lottoMoney);

        LottoOutput.printPurchaseNumbers(lottoGame.getLottoCount());
        LottoOutput.printLottoNumbers(lottoGame);

        String inputWinnerNumbers = LottoInput.inputWinnerNumbers();
        Lotto winnerNumbers = Lotto.newStringLotto(inputWinnerNumbers);

        LottoTotalCalculator lottoTotalCalculator = new LottoTotalCalculator();
        Map<WinnerTier, Integer> WinningResult = lottoTotalCalculator.countWinners(lottoGame, winnerNumbers);
        double Yield = lottoTotalCalculator.returnYield(lottoMoney);

        LottoOutput.printWinningStatistics(WinningResult, Yield);
    }
}
