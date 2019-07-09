package lotto.domain;

import lotto.model.LottoOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryStore {

	public static final int PRICE_OF_TICKET = 1000;

	private TicketMachine machine;

	public LotteryStore(TicketMachine machine){
		this.machine = machine;
	}

	public LottoWallet buy(LottoOrder order) {


		List<LottoTicket> tickets = order.getManualOrders()
				.stream()
				.map(numbers -> LottoTicket.of(numbers))
				.collect(Collectors.toList());

		int availableCount = order.getAutoOrderCount();

		tickets.addAll(IntStream.range(0, availableCount)
				.mapToObj(index -> this.issuingTicket())
				.collect(Collectors.toList()));

		return new LottoWallet(tickets);
	}

	private LottoTicket issuingTicket(){
		return this.machine.issuingTicket();
	}
}
