package lotto;

public class Main {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine(InputView.inputMoney());
		ResultView.printPurchaseResult(lottoMachine.getPurchasedLotto());

		Lotto winningLotto = new Lotto(InputView.inputWinningNumber());

		LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoMachine.getPurchasedLotto(), winningLotto);
		ResultView.printResult(lottoMatchResult);
	}
}
