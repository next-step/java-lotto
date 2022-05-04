package lotto;

import lotto.domain.Draw;
import lotto.domain.Winnings;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();

        Draw draw = new Draw(price);
        draw.drawLottos();

        ResultView resultView = new ResultView();
        resultView.printLottos(draw);

        String[] inputNumbers = inputView.inputLastWinningNumbers();
        Winnings winnings = new Winnings(inputNumbers);
        draw.checkWinnings(winnings);
        resultView.checkWinningsLotto(draw.winnings());
        resultView.printEarningsRatio(price, winnings.winningsRewards());
    }
}
