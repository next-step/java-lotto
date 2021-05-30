package lotto;

public class Main {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine(InputView.inputMoney());
		ResultView.printPurchaseResult(lottoMachine.getPurchasedLotto());

		WinningLotto winningLotto = new WinningLotto(InputView.inputWinningNumber(), InputView.inputBonusNumber());

		LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoMachine.getPurchasedLotto(), winningLotto);
		ResultView.printResult(lottoMatchResult);
	}
}
