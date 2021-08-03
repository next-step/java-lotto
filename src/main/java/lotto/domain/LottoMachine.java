package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	private static final int FIRST_NUMBER = 1;
	private static final int LAST_NUMBER = 45;
	private static final int INITIAL_INDEX = 0;
	private static final int COUNT_OF_LOTTO_NUMBERS = 6;

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

	public LottoTickets issueLottoTickets(Money money, List<LottoNumbers> manualLottoTicketNumbers) {
		int availableLottoTicketsCount = money.availableLottoTicketsCount();
		int autoLottoTicketsCount = availableLottoTicketsCount - manualLottoTicketNumbers.size();
		List<LottoTicket> autoLottoTickets = issueAutoLottoTickets(autoLottoTicketsCount);
		List<LottoTicket> manualLottoTickets = issueManualLottoTickets(manualLottoTicketNumbers);

		List<LottoTicket> lottoTickets = new ArrayList<>();
		lottoTickets.addAll(manualLottoTickets);
		lottoTickets.addAll(autoLottoTickets);

		return LottoTickets.from(lottoTickets);
	}

	private List<LottoTicket> issueManualLottoTickets(List<LottoNumbers> manualLottoTicketNumbers) {
		return manualLottoTicketNumbers.stream()
				.map(LottoNumbers::toLottoTicket)
				.collect(Collectors.toList());
	}

	private List<LottoTicket> issueAutoLottoTickets(int autoLottoTicketsCount) {
		return IntStream.range(INITIAL_INDEX, autoLottoTicketsCount)
				.mapToObj(index -> LottoTicket.from(pickRandomLottoNumbers()))
				.collect(Collectors.toList());
	}

	private List<Integer> initializeNumbers() {
		return IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}
}
