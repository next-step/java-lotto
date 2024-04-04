package lotto.domain.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberStrategy implements LottoNumberStrategy{
	private final List<Integer> numbers;

	public ManualLottoNumberStrategy(List<Integer> numbers) {
		if(numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 번호는" + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
		}

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
