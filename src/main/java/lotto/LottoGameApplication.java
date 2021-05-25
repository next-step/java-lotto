package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.LottoRandomNumbersGenerator;

public class LottoGameApplication {

	public static void main(String[] args) {
		LottoGameController controller = new LottoGameController(new LottoRandomNumbersGenerator());
		controller.play();
	}

}