package lotto;

import lotto.domain.Draw;
import lotto.domain.Winnings;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.util.Ratio.lottoEarningRatio;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();

        Draw draw = new Draw(price);
        draw.drawLottos(null);

        ResultView resultView = new ResultView();
        resultView.printLottos(draw);

        String[] inputNumbers = inputView.inputLastWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        Winnings winnings = new Winnings(inputNumbers, bonusNumber);
        draw.checkWinnings(winnings);
        resultView.printWinningsLotto(draw.winnings());
        resultView.printEarningsRatio(lottoEarningRatio(winnings.winningsRewards(), price));
    }
}
