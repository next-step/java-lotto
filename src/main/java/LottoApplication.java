import domain.Lotto;
import domain.Lottos;
import view.InputView;
import view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int price = InputView.promptForPurchasePrice();
        Lottos lottos = new Lottos(price);
        ResultView.print(lottos);

        Lotto winningLotto = new Lotto(InputView.promptForWinningNumbers());
        ResultView.printRanks(lottos.ranks(winningLotto));
        ResultView.printRateOfReturn(lottos.rateOfReturn(winningLotto));
    }
}
