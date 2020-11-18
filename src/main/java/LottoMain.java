import controller.LottoController;
import domain.LottoNumbers;
import domain.Lottos;
import view.InputView;
import view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int price = inputView.inputPrice();

        LottoController controller = new LottoController(price);
        Lottos lottos = controller.initLottos();

        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(inputView.inputLastWinningNumber());

        resultView.displayResultMention();
        resultView.displayStatistic(controller.compileLottoStatistics(winningNumbers, lottos));
    }
}
