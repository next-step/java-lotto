package nextstep.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {
	private static final List<Integer>  rangeLottoNumbers = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());

	public Lotto getAutoNumbers() {
		Collections.shuffle(rangeLottoNumbers);
		Set<LottoNumber> autoLottoNumbers = rangeLottoNumbers.stream()
				.limit(Lotto.LOTTO_SIZE)
				.map(LottoNumber::of)
				.collect(Collectors.toSet());
		return new Lotto(Collections.unmodifiableSet(new TreeSet<>(autoLottoNumbers)));
	}
}
