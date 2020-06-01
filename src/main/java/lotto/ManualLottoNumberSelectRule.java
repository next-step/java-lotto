package lotto;

import java.util.Collections;
import java.util.Set;

public class ManualLottoNumberSelectRule implements LottoNumberSelectRule {

	private final Set<Integer> numbers;

	public ManualLottoNumberSelectRule(Set<Integer> numbers) {
		this.numbers = Collections.unmodifiableSet(numbers);
	}

	@Override
	public Set<Integer> select() {
		return numbers;
	}
}
