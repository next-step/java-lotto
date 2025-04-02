import lotto.Seller;
import ui.InputView;
import ui.OutputView;

public class Main {
    public static void main(String[] args) {

        int purchaseAmount = InputView.inputPurchaseAmount();

        var seller = new Seller();
        var lottoTickets = seller.sell(purchaseAmount);

        OutputView.printLottoTickets(lottoTickets);

        var winningNumbers = InputView.inputWinningNumbers();
        var bonusNumber = InputView.inputBonusNumber();


        OutputView.printResult(winningNumbers, bonusNumber, lottoTickets);
    }
}
