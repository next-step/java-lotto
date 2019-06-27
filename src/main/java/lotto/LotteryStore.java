package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryStore {

	private static final int PRICE = 1000;

	public List<LottoTicket> buy(int money) {

		int availableCount = money / PRICE;

		return IntStream.range(0, availableCount)
				.mapToObj(index -> new LottoTicket())
				.collect(Collectors.toList());
	}
}
