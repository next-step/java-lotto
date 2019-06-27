package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryStore {

	private static final int PRICE = 1000;

	public LottoWallet buy(int money) {

		int availableCount = money / PRICE;

		List<LottoTicket> tickets = IntStream.range(0, availableCount)
				.mapToObj(index -> this.issuingTicket())
				.collect(Collectors.toList());

		return new LottoWallet(tickets, money % PRICE);
	}

	private LottoTicket issuingTicket(){
		LottoTicket ticket = new LottoTicket();
		IntStream.range(1, LottoRule.MAX_COUNT + 1)
				.forEach(number -> ticket.add(number));

		return ticket;
	}
}
