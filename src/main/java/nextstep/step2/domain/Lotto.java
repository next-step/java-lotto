package nextstep.step2.domain;

import java.util.Set;

public class Lotto {
	private Set<Integer> numbers;

	public Lotto(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}
}
