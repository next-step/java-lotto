package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.LottoRandomNumbersGenerator;
import lotto.view.InputView;

public class LottoGameApplication {

	public static void main(String[] args) {
		LottoGameController controller = new LottoGameController(new InputView(), new LottoRandomNumbersGenerator());
		controller.play();
	}

}