package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachine {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int FROM_INDEX = 0;
	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final List<LottoNumber> LOTTO_NUMBER_LIST = unmodifiableLottoNumberList();

	private static List<LottoNumber> unmodifiableLottoNumberList() {
		return Collections.unmodifiableList(
				IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
						.mapToObj(LottoNumber::of)
						.collect(Collectors.toList()));
	}

	List<LottoTicket> generate(int count) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			lottoTicketList.add(generate());
		}

		return Collections.unmodifiableList(lottoTicketList);
	}

	static LottoTicket generate() {
		ArrayList<LottoNumber> lottoNumberList = new ArrayList<>(LOTTO_NUMBER_LIST);
		Collections.shuffle(lottoNumberList);
		List<LottoNumber> shuffledList = lottoNumberList.subList(FROM_INDEX, LOTTO_NUMBER_COUNT);

		return new LottoTicket(Collections.unmodifiableSet(new HashSet<>(shuffledList)));
	}

}
