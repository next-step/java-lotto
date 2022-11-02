package step2.model;

import java.util.List;

public class Lotto {

	private List<Integer> numbers;


	private Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getLotto() {
		return numbers;
	}

	public static Lotto randomLotto() {
		RandomLottoFactory lottoFactory = new RandomLottoFactory();
		return new Lotto(lottoFactory.randomLotto());
	}

	public static Lotto handLotto(List<Integer> handLotto) {
		return new Lotto(handLotto);

	}

}