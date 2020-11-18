import controller.LottoController;
import domain.LottoNumbers;
import domain.Lottos;
import view.InputView;
import view.ResultView;

import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int price = inputView.inputPrice();

        LottoController controller = new LottoController(price);

        resultView.displayLottoQuantity(controller.getLottoQuantity());

        Lottos lottos = controller.initLottos();

        resultView.displayLottos(lottos);

        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(inputView.inputLastWinningNumber());

        resultView.displayResultMention();

        Map<Integer, Integer> lottoStatistics = controller.compileLottoStatistics(winningNumbers, lottos);
        resultView.displayStatistic(lottoStatistics);

        double profit = controller.calculateProfit(lottoStatistics, price);
        resultView.displayProfit(profit);
    }
}
