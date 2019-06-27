package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketMachine {

	List<Integer> numberPool;

	public TicketMachine(){

		numberPool = IntStream.rangeClosed(1, LottoRule.MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

	public LottoTicket issuingTicket(){

		LottoTicket ticket = new LottoTicket();
		Collections.shuffle(numberPool);

		IntStream.range(0, LottoRule.MAX_COUNT)
				.forEach(index -> ticket.add(numberPool.get(index)));

		return ticket;
	}
}
