package lotto.domain.strategy;

import java.util.HashSet;
import java.util.Set;

import lotto.domain.LottoNumber;

public class ManualGenerateStrategy implements GenerateStrategy{
	private Set<LottoNumber> numbers;

	public ManualGenerateStrategy(int... nums) {
		numbers = new HashSet<>();
		for (int num : nums) {
			numbers.add(new LottoNumber(num));
		}
	}

	@Override
	public Set<LottoNumber> generate() {
		return numbers;
	}
}
