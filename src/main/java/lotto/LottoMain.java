package lotto;

import lotto.domain.Draw;
import lotto.util.Splitter;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();

        Draw draw = new Draw(price);
        draw.drawLottos();

        ResultView resultView = new ResultView();
        resultView.printLottos(draw);

        String[] inputNumbers = inputView.inputLastWinningNumbers();
    }
}
