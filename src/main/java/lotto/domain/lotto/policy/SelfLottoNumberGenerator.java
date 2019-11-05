package lotto.domain.lotto.policy;

import java.util.Collections;
import java.util.List;

public class SelfLottoNumberGenerator implements LottoNumbersGeneratePolicy {

	private final List<Integer> inputNumbers;

	public SelfLottoNumberGenerator(List<Integer> inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	@Override
	public List<Integer> generate() {
		return Collections.unmodifiableList(inputNumbers);
	}

}
