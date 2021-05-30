package lotto;

public class Main {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine(InputView.inputMoney(), InputView.inputManualLotto());
		ResultView.printPurchaseResult(lottoMachine);

		WinningLotto winningLotto = new WinningLotto(InputView.inputLottoNumber(), InputView.inputBonusNumber());
		LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoMachine.getPurchasedLotto(), winningLotto);
		ResultView.printResult(lottoMatchResult);
	}
}
