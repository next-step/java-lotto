package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private List<Integer> numbers;

	public Lotto() {
		List<Integer> lottoCard = LottoCard.NUMBERS;
		Collections.shuffle(lottoCard);
		List<Integer> numbers = new ArrayList<>(lottoCard.subList(0, 6));
		Collections.sort(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
