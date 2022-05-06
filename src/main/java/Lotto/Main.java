package Lotto;

import Lotto.Model.LottoCard;
import Lotto.Model.LottoGame;
import Lotto.View.InputView;
import Lotto.View.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputCash());

        OutputView.printBuyCount(lottoGame.getLottoList().size());
        OutputView.printLottoGame(lottoGame.getLottoList());

        lottoGame.calculate(new LottoCard(InputView.inputLastWeekWinningNumber()), InputView.inputBonus());

        OutputView.printPrize(lottoGame);
    }
}
