import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        final PurchasePrice purchasePrice = new PurchasePrice(InputView.inputPurchasePrice());
        final Lottos lottos = new Lottos(purchasePrice);
        ResultView.printLottos(lottos);

        final WinningNumber winningNumber = generateWinningNumber();
        final LottoResult lottoResult = lottos.calculateLottoResult(winningNumber);
        ResultView.printLottoStatistics(lottoResult,purchasePrice);
    }

    private static WinningNumber generateWinningNumber() {
        return new WinningNumber(InputView.inputWinningNumber().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }
}
