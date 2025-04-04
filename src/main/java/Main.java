import lotto.Seller;
import ui.InputView;
import ui.OutputView;

public class Main {
    public static void main(String[] args) {

        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualGameCount = InputView.inputManualGameCount();
        var pickedNumbers = InputView.inputPickedNumbers(manualGameCount);

        var seller = new Seller();
        var lottoTickets = seller.sell(purchaseAmount, pickedNumbers);

        OutputView.printLottoTickets(lottoTickets);

        var winningNumbers = InputView.inputWinningNumbers();
        var bonusNumber = InputView.inputBonusNumber();


        OutputView.printResult(winningNumbers, bonusNumber, lottoTickets);
    }
}
