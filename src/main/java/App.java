import calculator.Calculator;
import lotto.Lotto;
import lotto.LottoWinning;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        Calculator.calculate("1 - 3 + 55 * 1");
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
