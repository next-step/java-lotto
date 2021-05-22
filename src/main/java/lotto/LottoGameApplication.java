package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.LottoRandomNumbersGenerator;
import lotto.service.InputService;

public class LottoGameApplication {

	public static void main(String[] args) {
		LottoGameController controller = new LottoGameController(new InputService(), new LottoRandomNumbersGenerator());
		controller.play();
	}

}