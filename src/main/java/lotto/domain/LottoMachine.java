package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	private static final int FIRST_NUMBER = 1;
	private static final int LAST_NUMBER = 45;
	private static final int INITIAL_INDEX = 0;
	private static final int COUNT_OF_LOTTO_NUMBERS = 6;
	private static final int PRICE_PER_TICKET = 1_000;

	private final List<Integer> numbers;

	public LottoMachine() {
		this.numbers = initializeNumbers();
	}

	public List<Integer> pickRandomLottoNumbers() {
		Collections.shuffle(numbers);
		return IntStream.range(INITIAL_INDEX, COUNT_OF_LOTTO_NUMBERS)
				.mapToObj(numbers::get)
				.collect(Collectors.toList());
	}

	public LottoTickets issueLottoTickets(int money) {
		List<LottoTicket> lottoTickets = IntStream.range(INITIAL_INDEX, calculateLottoTicketCount(money))
											.mapToObj(index -> LottoTicket.from(pickRandomLottoNumbers()))
											.collect(Collectors.toList());
		return LottoTickets.from(lottoTickets);
	}

	private int calculateLottoTicketCount(int money) {
		return money / PRICE_PER_TICKET;
	}

	private List<Integer> initializeNumbers() {
		return IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}
}
