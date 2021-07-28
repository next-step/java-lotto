package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	private static final int FIRST_NUMBER = 1;
	private static final int LAST_NUMBER = 45;
	private static final int FIRST_INDEX = 0;
	private static final int SIXTH_INDEX = 6;
	private static final int PRICE_PER_TICKET = 1_000;
	private final List<Integer> numbers;

	public LottoMachine() {
		this.numbers = initializeNumbers();
	}

	public List<LottoNumber> pickRandomNumbers() {
		Collections.shuffle(numbers);
		return IntStream.range(FIRST_INDEX, SIXTH_INDEX)
				.mapToObj(index -> new LottoNumber(numbers.get(index)))
				.collect(Collectors.toList());
	}

	public List<LottoTicket> issueLottoTickets(int price) {
		return IntStream.range(FIRST_INDEX, numberOfLottoTickets(price))
				.mapToObj(index -> LottoTicket.from(pickRandomNumbers()))
				.collect(Collectors.toList());
	}

	private int numberOfLottoTickets(int price) {
		return price / PRICE_PER_TICKET;
	}

	private List<Integer> initializeNumbers() {
		return IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
			.boxed()
			.collect(Collectors.toList());
	}
}
