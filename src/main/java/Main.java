import lotto.domain.LottoMarket;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.io.InputView;
import lotto.io.PrintView;

public class Main {
	public static void main(String[] args) {
		LottoPrice lottoPrice = new LottoPrice(InputView.inputPurchasePrice());
		int numberOfLotto = lottoPrice.getNumberOfLotto();
		PrintView.printNumberOfLotto(numberOfLotto);

		LottoMarket lottoMarket = new LottoMarket(numberOfLotto);
		PrintView.printLottos(lottoMarket.getLottos());

		WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
		LottoResult lottoResult = new LottoResult(winningNumbers, lottoMarket.getLottos(), lottoPrice);
		PrintView.printLottoResult(lottoResult);
	}
}
