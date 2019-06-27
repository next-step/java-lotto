package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryStore {

	private static final int PRICE = 1000;

	public List<LottoTicket> buy(int money) {

		int availableCount = money / PRICE;

		return IntStream.range(0, availableCount)
				.mapToObj(index -> this.issuingTicket())
				.collect(Collectors.toList());
	}

	private LottoTicket issuingTicket(){
		LottoTicket ticket = new LottoTicket();
		IntStream.range(1, LottoTicket.MAX_COUNT + 1)
				.forEach(number -> ticket.add(number));

		return ticket;
	}
}
