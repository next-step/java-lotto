package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoMachine {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int FROM_INDEX = 0;
	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final List<LottoNumber> LOTTO_NUMBER_LIST = new ArrayList<>(LOTTO_NUMBER_UPPER_BOUND);

	static {
		initialize();
	}

	private static void initialize() {
		for (int i = LottoMachine.LOTTO_NUMBER_LOWER_BOUND; i <= LottoMachine.LOTTO_NUMBER_UPPER_BOUND; i++) {
			LottoMachine.LOTTO_NUMBER_LIST.add(LottoNumber.of(i));
		}
	}

	static LottoTicket generate() {
		Collections.shuffle(LOTTO_NUMBER_LIST);
		List<LottoNumber> lottoNumberList = LOTTO_NUMBER_LIST.subList(FROM_INDEX, LOTTO_NUMBER_COUNT);
		Collections.sort(lottoNumberList);
		Set<LottoNumber> lottoNumbers = Collections.unmodifiableSet(new HashSet<>(lottoNumberList));

		return new LottoTicket(lottoNumbers);
	}

	List<LottoTicket> generate(int count) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			lottoTicketList.add(generate());
		}

		return Collections.unmodifiableList(lottoTicketList);
	}

}
