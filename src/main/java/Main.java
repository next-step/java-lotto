import lotto.Controller.LottoController;
import lotto.Domain.Buyer;
import lotto.View.InputView;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(InputView.init(), Buyer.of());
        lottoController.purchaseLotto();
    }
}
