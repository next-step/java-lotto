package lotto.model;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupplierGenerateStrategy implements LottoNumbersGenerateStrategy {
	private final Supplier<List<Integer>> supplier;

	public SupplierGenerateStrategy(Supplier<List<Integer>> supplier) {
		this.supplier = supplier;
	}

	@Override
	public List<LottoNumbers> generate(int count) {
		return IntStream.range(FROM_ZERO, count)
			.mapToObj((i) -> new LottoNumbers(supplier.get()))
			.collect(Collectors.toList());
	}
}
