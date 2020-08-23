package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoIssuer {
	private static final List<LottoNumber> LOTTO_VALUES = new ArrayList<>();
	private static final int LOTTO_NUMBER_LENGTH = 6;

	static {
		for (int i = 0; i < LottoNumber.MAX_LOTTO_VALUE; i++) {
			LOTTO_VALUES.add(new LottoNumber(i+1));
		}
	}

	public List<LottoNumber> issueAutoLotto() {
		Collections.shuffle(LOTTO_VALUES);
		return LOTTO_VALUES.stream()
				.limit(LOTTO_NUMBER_LENGTH)
				.sorted()
				.collect(Collectors.toList());
	}
}
