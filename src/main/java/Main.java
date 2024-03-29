import lotto.domain.LottoMarket;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.io.InputView;
import lotto.io.PrintView;

public class Main {
	private static final int LOTTO_PURCHASE = 1000;

	public static void main(String[] args) {
		int purchasePrice = InputView.inputPurchasePrice();
		int numberOfLotto = purchasePrice / LOTTO_PURCHASE;
		PrintView.printNumberOfLotto(numberOfLotto);

		LottoMarket lottoMarket = new LottoMarket(numberOfLotto);
		PrintView.printLottos(lottoMarket.getLottos());

		WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
		LottoResult lottoResult = new LottoResult(winningNumbers, lottoMarket.getLottos(), purchasePrice);
		PrintView.printLottoResult(lottoResult);
	}
}
