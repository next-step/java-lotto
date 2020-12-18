package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLottery;
import lotto.domain.LottoNumber;
import lotto.domain.Message;
import lotto.domain.Money;
import lotto.utils.RandomLottoNumberGenerator;

public class LottoService {
	private final Money money;

	public LottoService(Money money) {
		this.money = money;
	}

	public LottoLotteries buyMaxLottoLotteries() {
		int count = money.buyMax(LottoLottery.getPrice());
		validateBuyLottoLottery(count);

		return buyAutoLottoLotteries(count);
	}

	private void validateBuyLottoLottery(int count) {
		if (count == 0) {
			throw new IllegalArgumentException(Message.INVALID_BUY_LOTTO);
		}
	}

	private LottoLotteries buyAutoLottoLotteries(int count) {
		return new LottoLotteries(createAutoLottoLotteries(count));
	}

	private List<LottoLottery> createAutoLottoLotteries(int count) {
		return IntStream.range(0, count)
			.mapToObj(value -> new LottoLottery(getAutoNumbers()))
			.collect(Collectors.toList());
	}

	private List<LottoNumber> getAutoNumbers() {
		return new RandomLottoNumberGenerator().generate();
	}
}
