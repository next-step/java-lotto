package step2;

import step2.controller.LottoController;

public class Main {

	public static void main(String[] args) {
		LottoController lottoController = new LottoController();

		lottoController.purchase();
		lottoController.getWinningNumber();
		lottoController.getWinningStatistics();
	}
}
