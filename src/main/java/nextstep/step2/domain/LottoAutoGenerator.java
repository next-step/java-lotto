package nextstep.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {
	private static final int RANDOM_COUNT = 6;
	private static final List<Integer>  rangeLottoNumbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());

	public Set<Integer> getAutoNumbers() {
		Collections.shuffle(rangeLottoNumbers);
		return rangeLottoNumbers.stream()
				.limit(RANDOM_COUNT)
				.sorted()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
	}
}
