package lotto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine(InputView.inputMoney());
		Lottos manuals = lottoMachine.purchaseManual(InputView.inputManualLotto());
		Lottos autos = lottoMachine.purchaseAuto(lottoMachine.purchaseLottoCount() - manuals.lottoCount());
		Lottos purchaseAll = new Lottos(Stream.concat(autos.getLottos().stream(),
			manuals.getLottos().stream()).collect(Collectors.toList()));

		ResultView.printPurchaseResult(autos, manuals);

		WinningLotto winningLotto = new WinningLotto(InputView.inputLottoNumber(), InputView.inputBonusNumber());
		LottoMatchResult lottoMatchResult = new LottoMatchResult(purchaseAll, winningLotto);
		ResultView.printResult(lottoMatchResult);
	}
}
