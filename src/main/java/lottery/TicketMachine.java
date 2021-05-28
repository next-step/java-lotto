package lottery;

import static lottery.util.RandomUtil.*;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class TicketMachine {

	private static final int LOTTERY_MAXIMUM_NUMBER = 45;
	private static final int LOTTERY_MINIMUM_NUMBER = 1;

	public Tickets automaticTicketCreate(long count) {
		return Tickets.of(LongStream.range(0, count)
			.mapToObj(a -> LottoNumbers.from(generateSixLottoNoes(LOTTERY_MINIMUM_NUMBER, LOTTERY_MAXIMUM_NUMBER)))
			.map(numbers -> Ticket.of(numbers, TicketType.AUTO))
			.collect(Collectors.toList()));
	}
}
