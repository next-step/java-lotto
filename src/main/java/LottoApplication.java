import domain.Lotto;
import domain.Lottos;
import domain.WinningStatistics;
import view.InputView;
import view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {


        int amount = InputView.inputAmount();
        Lottos lottos = new Lottos(amount);

        ResultView.printPurchaseCount(lottos.size());
        ResultView.printLottos(lottos.getLottoList());


        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
        WinningStatistics winningStatistics = new WinningStatistics(lottos.checkResult(winningLotto));

        ResultView.printStatistics(winningStatistics);
        ResultView.printProfitRate(winningStatistics.profitRate(amount));

    }
}
