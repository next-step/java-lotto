package lotto;

public class Main {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine(InputView.inputMoney());
		Lotto winningLotto = new Lotto(InputView.inputWinningNumber());
		LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoMachine.getPurchasedLotto(), winningLotto);
		lottoMatchResult.printResult();
	}
}
