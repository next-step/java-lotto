package step2.model;

import java.util.List;
import java.util.Objects;

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

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotto lotto = (Lotto) o;
		return Objects.equals(numbers, lotto.numbers);
	}

	public int hashCode() {
		return Objects.hash(numbers);
	}
}
