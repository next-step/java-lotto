import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        final PurchasePrice purchasePrice = new PurchasePrice(InputView.inputPurchasePrice());
        final Lottos lottos = new Lottos(purchasePrice);
        ResultView.printLottos(lottos);
    }
}
