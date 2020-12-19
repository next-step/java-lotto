package step2.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoNumbers {

	private final int MAX_SIZE = 6;
	private final Set<LottoNumber> numbers;

	public LottoNumbers() {
		this.numbers = generate();
	}

	private Set<LottoNumber> generate() {
		Set<LottoNumber> numbers = new HashSet<>(MAX_SIZE);
		while (numbers.size() < MAX_SIZE) {
			numbers.add(new LottoNumber());
		}
		return numbers;
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	public int size() {
		return numbers.size();
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}
}
