package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	private static final Integer INIT_NUMBER = 0;

	public static void main(String[] args) {

		Input input = new Input();
		Result result = new Result();
		LottoNumberGenerator generator = new LottoNumberGenerator();
		List<Lotto> lottoList = new ArrayList<>();
		LottoCalculator calculator = new LottoCalculator();

		Integer account = input.setAccount();
		Integer lottoCount = calculator.getLottoCount(account);
		input.viewLottoCount(lottoCount);

		for (int number = INIT_NUMBER ; number < lottoCount ; ++number) {
			Lotto lotto = generator.getLottoNumber();
			lottoList.add(lotto);
			result.viewLotto(lotto);
		}

		List<Rank> container = calculator.getResult(lottoList, input.lottoWinningNumber(), input.setBonusNumber());
		result.viewResult(container);
	}
}
