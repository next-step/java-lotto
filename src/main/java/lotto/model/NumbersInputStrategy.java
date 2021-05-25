package lotto.model;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class NumbersInputStrategy implements LottoNumbersGenerateStrategy {
	private final Supplier<List<Integer>> numbersSupplier;

	public NumbersInputStrategy(Supplier<List<Integer>> numbersSupplier) {
		this.numbersSupplier = numbersSupplier;
	}

	@Override
	public List<LottoNumbers> generate(Count count) {
		return count.streamFromZero()
			.mapToObj((i) -> new LottoNumbers(numbersSupplier.get()))
			.collect(Collectors.toList());
	}
}
