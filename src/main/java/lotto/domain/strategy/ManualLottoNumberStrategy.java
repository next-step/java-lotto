package lotto.domain.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberStrategy implements LottoNumberStrategy{
	private final List<Integer> numbers;

	public ManualLottoNumberStrategy(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public ManualLottoNumberStrategy(String[] numbers) {
		this(Arrays.stream(numbers)
				.map(Integer::parseInt)
				.collect(Collectors.toList()));
	}

	@Override
	public List<Integer> generateLottoNumber() {
		return this.numbers;
	}
}
