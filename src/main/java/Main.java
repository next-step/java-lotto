import lotto.domain.*;
import lotto.domain.strategy.AutoLottoNumberStrategy;
import lotto.domain.strategy.ManualLottoNumberStrategy;
import lotto.io.InputView;
import lotto.io.PrintView;

public class Main {
	public static void main(String[] args) {
		LottoPrice lottoPrice = new LottoPrice(InputView.inputPurchasePrice(), InputView.inputNumberOfManualLotto());
		int numberOfAutoLotto = lottoPrice.getNumberOfAutoLotto();
		int numberOfManualLotto = lottoPrice.getNumberOfManualLotto();

		LottoMarket lottoMarket = new LottoMarket(numberOfAutoLotto, new AutoLottoNumberStrategy());

		if(numberOfManualLotto > 0) {
			PrintView.printAutoLottoGuide();
		}

		for(int i = 0; i < numberOfManualLotto; i++) {
			lottoMarket.addLotto(new ManualLottoNumberStrategy(InputView.inputLottoNumber()));
		}

		PrintView.printNumberOfLotto(numberOfManualLotto, numberOfAutoLotto);

		PrintView.printLottos(lottoMarket.getLottos());

		WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
		LottoResult lottoResult = new LottoResult(winningNumbers, lottoMarket.getLottos(), lottoPrice);
		PrintView.printLottoResult(lottoResult);
	}
}
