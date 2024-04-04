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

		Lottos lottos = new Lottos();

		PrintView.printAutoLottoGuide();

		for(int i = 0; i < numberOfManualLotto; i++) {
			lottos.add(new Lotto(new ManualLottoNumberStrategy(InputView.inputLottoNumber())));
		}

		for(int i = 0; i < numberOfAutoLotto; i++) {
			lottos.add(new Lotto(new AutoLottoNumberStrategy()));
		}

		PrintView.printNumberOfLotto(numberOfManualLotto, numberOfAutoLotto);

		PrintView.printLottos(lottos.getLottos());

		WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
		LottoResult lottoResult = new LottoResult(winningNumbers, lottos.getLottos(), lottoPrice);
		PrintView.printLottoResult(lottoResult);
	}
}
