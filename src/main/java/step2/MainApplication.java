package step2;

import step2.controller.LottoController;
import step2.util.LottoGenerator;
import step2.util.RandomLottoGenerator;

public class MainApplication {
	public static void main(String[] args) {
		LottoGenerator lottoGenerator = new RandomLottoGenerator();
		LottoController lottoController = new LottoController(lottoGenerator);
		lottoController.buyLotto();
	}
}
