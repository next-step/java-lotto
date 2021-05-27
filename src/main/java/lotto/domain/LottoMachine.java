package lotto.domain;

import lotto.function.FillList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.CollectionUtils.*;

class LottoMachine {

	private static final int FROM_INDEX = 0;
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final List<LottoNumber> lottoNumberList = unmodifiableLottoNumberList();

	private static List<LottoNumber> unmodifiableLottoNumberList() {
		return IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
				.mapToObj(LottoNumber::of)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
	}

	List<LottoTicket> generate(int count) {
		return Collections.unmodifiableList(new FillList<LottoTicket>()
				.apply(count, this::generate));
	}

	private LottoTicket generate() {
		ArrayList<LottoNumber> tempLottoNumberList = new ArrayList<>(lottoNumberList);
		Collections.shuffle(tempLottoNumberList);
		List<LottoNumber> shuffledList = tempLottoNumberList.subList(FROM_INDEX, LOTTO_NUMBER_COUNT);

		return new LottoTicket(Collections.unmodifiableSet(new HashSet<>(shuffledList)));
	}

	public List<LottoTicket> manual(List<String> numberStrings) {
		return transform(numberStrings, new ArrayList<>(), LottoTicketConverter::convert);
	}
}
