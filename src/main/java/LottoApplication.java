import step2.controller.LottoController;
import step2.model.RandomLottoFactory;

public class LottoApplication {
	public static void main(String[] args) {
		new LottoController().startLotto(new RandomLottoFactory());
	}
}
