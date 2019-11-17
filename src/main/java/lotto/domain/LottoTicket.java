package lotto.domain;

import java.util.*;

public class LottoTicket {

	private List<Integer> ticketNumbers = new ArrayList<>();

	private static final int NUMBER_COUNT = 6;

	public LottoTicket() {
		Random random = new Random();
		Set<Integer> set = new HashSet<>();

		while (set.size() < NUMBER_COUNT) {
			set.add(random.nextInt(45) + 1);
		}

		ticketNumbers.addAll(set);
	}

	public List<Integer> getTicketNumbers() {
		return ticketNumbers;
	}

}
