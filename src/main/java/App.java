import calculator.Calculator;
import lotto.Lotto;
import lotto.LottoWinning;
import lotto.Rank;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Rank, Integer> results = new HashMap<>();

        String price = InputView.getPrice();
        Lotto lotto = new Lotto(price);
        lotto.auto();
        ResultView.printBuyQuantityMessage(lotto.getBuyQuantity());
        ResultView.printBuyLottoNumbers(lotto);

        String winningNumber = InputView.getLastWinningNumber();
        ResultView.printWinningTitle();;
        ResultView.printWinningResultsAndReturnRate(new LottoWinning(winningNumber, lotto));
    }
}
