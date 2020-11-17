package nextstep.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {
	private static final List<Integer>  rangeLottoNumbers = IntStream.range(Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());

	public Set<Integer> getAutoNumbers() {
		Collections.shuffle(rangeLottoNumbers);
		return rangeLottoNumbers.stream()
				.limit(Lotto.LOTTO_SIZE)
				.sorted()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
	}
}
