package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryStore {

	public static final int PRICE_OF_TICKET = 1000;

	private TicketMachine machine;

	public LotteryStore(TicketMachine machine){
		this.machine = machine;
	}

	public LottoWallet buy(int money) {

		int availableCount = money / PRICE_OF_TICKET;

		List<LottoTicket> tickets = IntStream.range(0, availableCount)
				.mapToObj(index -> this.issuingTicket())
				.collect(Collectors.toList());

		return new LottoWallet(tickets, money % PRICE_OF_TICKET);
	}

	private LottoTicket issuingTicket(){
		return this.machine.issuingTicket();
	}
}
