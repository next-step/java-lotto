package lotto.model;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierGenerateStrategy implements LottoNumbersGenerateStrategy {
	private final Supplier<List<Integer>> supplier;

	public SupplierGenerateStrategy(Supplier<List<Integer>> supplier) {
		this.supplier = supplier;
	}

	@Override
	public List<LottoNumbers> generate(Count count) {
		return count.streamFromZero()
			.mapToObj((i) -> new LottoNumbers(supplier.get()))
			.collect(Collectors.toList());
	}
}
