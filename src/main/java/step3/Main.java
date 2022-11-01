package step3;

import step3.controller.LottoController;

public class Main {

	public static void main(String[] args) {
		LottoController lottoController = new LottoController();

		lottoController.purchase();
		lottoController.getWinningNumber();
		lottoController.getWinningStatistics();
	}
}
