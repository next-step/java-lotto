package step2;

import java.util.List;
import step2.model.Lotto;
import step2.model.LottoGame;
import step2.model.LottoMoney;
import step2.model.LottoPrize;
import step2.model.LottoPrizes;
import step2.model.LottoWinning;
import step2.model.Lottos;
import step2.util.LottoMakeNumbers;
import step2.view.LottoInput;
import step2.view.LottoOutput;

public class LottoMain {

    public static void main(String[] args) {
        int lottoMoney = LottoInput.inputGameMoney();
        List<Lotto> LottoList = LottoInput.inputInputSelfPurchase();

        LottoGame lottoGame = new LottoGame(new LottoMoney(lottoMoney), Lottos.of(LottoList));

        LottoOutput.printPurchaseNumbers(lottoGame.getLottoRandomCount(), lottoGame.getLottoSelfCount());
        LottoOutput.printLottoNumbers(lottoGame);

        LottoWinning lottoWinning = LottoWinning
            .of(LottoMakeNumbers.convertStringToNumbers(LottoInput.inputWinnerNumbers()),
                LottoInput.inputBonus());
        List<LottoPrize> lottoPrizeList = lottoGame.getLottos().getCalculate(lottoWinning);
        LottoPrizes lottoPrizes = LottoPrizes
            .of(lottoPrizeList, lottoGame.getLottos().resultLottoGamePayOffRatio(lottoPrizeList));
        LottoOutput.printWinningStatistics(lottoPrizes);
    }
}
