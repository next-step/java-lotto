package lotto;

import lotto.controller.LottoController;

public class Main {

	public static void main(String[] args) {
		LottoController controller = new LottoController();
		controller.buyLotto();
		controller.lookUpPrizes();
	}

}
