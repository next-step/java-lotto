package lotto.view;

public class LottoMain {
	public static void main(String[] args) {
		LottoManager lottoManager = new LottoManager(new InputView(), new OutputView());
		lottoManager.run();
	}
}
