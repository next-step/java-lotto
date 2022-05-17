package lotto;

import lotto.domain.Draw;
import lotto.domain.Winnings;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.util.Ratio.lottoEarningRatio;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();

        int numberOfLottosByHand = inputView.inputNumberOfLottosByHand();
        List<String[]> lottosByHand = inputView.inputLottosByHand(numberOfLottosByHand);

        Draw draw = new Draw(price, numberOfLottosByHand);
        draw.drawByHand(lottosByHand);
        draw.drawAuto();

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
