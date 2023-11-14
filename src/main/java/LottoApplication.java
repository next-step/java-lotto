import domain.LottoService;
import policy.LottoPrice;
import view.InputView;
import view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        Long money = InputView.inputLottoPurchaseAmount();
        ResultView.printLottoCount(money/LottoPrice.LOTTO_PRICE);
    }
}
