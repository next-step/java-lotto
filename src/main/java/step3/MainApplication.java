package step3;

import step3.controller.LottoController;
import step3.util.LottoGenerator;
import step3.util.RandomLottoGenerator;

public class MainApplication {
	public static void main(String[] args) {
		LottoGenerator lottoGenerator = new RandomLottoGenerator();
		LottoController lottoController = new LottoController(lottoGenerator);
		lottoController.game();
	}
}
