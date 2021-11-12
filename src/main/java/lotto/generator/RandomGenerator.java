package lotto.generator;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;
import lotto.domain.Ticket;

public class RandomGenerator implements Generator {
	private static final int FIRST_INDEX = 0;
	private static final List<Integer> NUMBERS =
		IntStream.rangeClosed(LottoNumber.MIN_OF_LOTTO_NUMBERS, LottoNumber.MAX_OF_LOTTO_NUMBERS)
			.boxed()
			.collect(toList());

	@Override
	public List<LottoNumber> generate() {
		Collections.shuffle(NUMBERS);
		return NUMBERS.subList(FIRST_INDEX, Ticket.SIZE_OF_LOTTO_TICKET).stream()
			.map(LottoNumber::create)
			.sorted()
			.collect(toList());
	}
}
