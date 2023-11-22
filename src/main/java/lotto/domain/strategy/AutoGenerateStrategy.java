package lotto.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoConfig;
import lotto.domain.LottoNumber;

public class AutoGenerateStrategy implements GenerateStrategy{

	@Override
	public Set<LottoNumber> generate() {
		List<LottoNumber> numbers
			= IntStream.rangeClosed(LottoConfig.LOWER_BOUND, LottoConfig.UPPER_BOUND)
			.boxed()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		Collections.shuffle(numbers);
		return Set.copyOf(numbers.subList(0, LottoConfig.NUMBERS_COUNT));
	}
}
