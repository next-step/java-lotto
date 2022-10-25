package step2;

import step2.controller.LottoController;

public class Main {
	private static final LottoController lottoController = new LottoController();

	public static void main(String[] args) {
		lottoController.purchase();
		lottoController.getWinningNumber();
		lottoController.getWinningStatistics();
	}
}
