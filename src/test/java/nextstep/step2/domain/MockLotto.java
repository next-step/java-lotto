package nextstep.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MockLotto {
	public static Lotto mockLotto(List<Integer> numbers) {
		Set<LottoNumber> lottoNumbers = numbers.stream()
				.map(LottoNumber::of)
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		return new Lotto(lottoNumbers);
	}
}
