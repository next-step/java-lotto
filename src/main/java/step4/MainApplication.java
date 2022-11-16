package step4;

import step4.controller.LottoController;
import step4.util.LottoGenerator;
import step4.util.RandomLottoGenerator;

public class MainApplication {
	public static void main(String[] args) {
		LottoGenerator lottoGenerator = new RandomLottoGenerator();
		LottoController lottoController = new LottoController(lottoGenerator);
		lottoController.game();
	}
}
