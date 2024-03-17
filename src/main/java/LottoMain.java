import controller.LottoController;
import view.InputView;
import view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        new LottoController(new InputView(), new OutputView()).play();

    }
}
