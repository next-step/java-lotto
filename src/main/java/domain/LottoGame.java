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

		Integer lottoCount = input.setAccount();

		for (int i = INIT_NUMBER ; i < lottoCount ; ++i) {
			lottoList.add(generator.getLottoNumber());
		}

		result.viewResult(calculator.getResult(lottoList, input.lottoWinningNumber()));
	}
}
