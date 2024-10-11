import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(InputView.getInstance(), ResultView.getInstance());
        lottoController.play();
    }
}
