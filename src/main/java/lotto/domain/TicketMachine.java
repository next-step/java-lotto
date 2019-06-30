package lotto.domain;

import lotto.model.LottoRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketMachine {

	List<Integer> numberPool;

	public TicketMachine(){
		numberPool = IntStream.rangeClosed(LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

	public LottoTicket issuingTicket(){
		Collections.shuffle(numberPool);

		int[] numbers = IntStream.range(0, LottoRule.MAX_COUNT)
				.map(index -> numberPool.get(index))
				.toArray();

		return LottoTicket.of(numbers);
	}
}
