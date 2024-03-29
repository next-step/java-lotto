package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberStrategy implements LottoNumberStrategy {
	private final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

	@Override
	public List<Integer> generateLottoNumber() {
		Collections.shuffle(numbers);
		return numbers.subList(0, 6);
	}
}
