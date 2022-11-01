package step2.model;

import java.util.List;
public class Lotto {

	private List<Integer> numbers;

	public Lotto(LottoFactory lottoFactory) {
		this(lottoFactory.getLottoNum());
	}

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getLotto() {
		return numbers;
	}

}
