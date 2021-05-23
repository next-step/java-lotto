package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LottoNumberPool {

	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>(LOTTO_NUMBER_UPPER_BOUND);
	private static final List<LottoNumber> LOTTO_NUMBER_LIST = new ArrayList<>(LOTTO_NUMBER_UPPER_BOUND);
	private static final int FROM_INDEX = 0;
	private static final int LOTTO_NUMBER_COUNT = 6;

	private LottoNumberPool() {
	}

	static {
		initialize();
	}

	private static void initialize() {
		for (int i = LOTTO_NUMBER_LOWER_BOUND; i <= LOTTO_NUMBER_UPPER_BOUND; i++) {
			LottoNumber lottoNumber = LottoNumber.of(i);
			LOTTO_NUMBER_MAP.put(i, lottoNumber);
			LOTTO_NUMBER_LIST.add(lottoNumber);
		}
	}

	static LottoTicket generate() {
		Collections.shuffle(LOTTO_NUMBER_LIST);
		List<LottoNumber> lottoNumberList = LOTTO_NUMBER_LIST.subList(FROM_INDEX, LOTTO_NUMBER_COUNT);
		Collections.sort(lottoNumberList);
		Set<LottoNumber> lottoNumbers = Collections.unmodifiableSet(new HashSet<>(lottoNumberList));

		return new LottoTicket(lottoNumbers);
	}

}
