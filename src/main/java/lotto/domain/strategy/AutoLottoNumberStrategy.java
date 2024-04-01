package lotto.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberStrategy implements LottoNumberStrategy {
	private final List<Integer> numbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX).boxed().collect(Collectors.toList());

	@Override
	public List<Integer> generateLottoNumber() {
		Collections.shuffle(numbers);
		return numbers.subList(0, LOTTO_NUMBER_COUNT);
	}
}
