package lotto.model;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersInputStrategy implements LottoNumbersGenerateStrategy {
	private final Supplier<List<Integer>> numbersSupplier;

	public NumbersInputStrategy(Supplier<List<Integer>> numbersSupplier) {
		this.numbersSupplier = numbersSupplier;
	}

	@Override
	public List<LottoNumbers> generate(int count) {
		return IntStream.range(0, count)
			.mapToObj((i) -> LottoNumbers.of(numbersSupplier.get()))
			.collect(Collectors.toList());
	}
}
