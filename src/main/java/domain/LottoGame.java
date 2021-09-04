package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	private static final Integer INIT_NUMBER = 0;

	public static void main(String[] args) {

		Input input = new Input();
		Result result = new Result();
		LottoNumberGenerator generator = new LottoNumberGenerator();
		List<List<Integer>> lottoList = new ArrayList<>();

		Integer lottoCount = input.setAccount();

		for (int i = INIT_NUMBER ; i < lottoCount ; ++i) {
			lottoList.add(generator.getLottoNumber());
		}

		result.viewResult();
	}
}
