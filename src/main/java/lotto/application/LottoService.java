package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLottery;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResults;
import lotto.domain.Message;
import lotto.domain.Money;
import lotto.domain.WinLottoNumbers;
import lotto.utils.RandomLottoNumberGenerator;

public class LottoService {
	private final LottoLotteries lottoLotteries;

	public LottoService(Money money) {
		this.lottoLotteries = buyMaxLottoLotteries(money);
	}

	public LottoLotteries buyMaxLottoLotteries(Money money) {
		int count = money.buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE);
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

	public LottoLotteries getLottoLotteries() {
		return lottoLotteries;
	}

	public LottoResults getLottoResults(WinLottoNumbers winLottoNumbers) {
		return lottoLotteries.getLottoResults(winLottoNumbers);
	}

	private List<LottoNumber> getAutoNumbers() {
		return new RandomLottoNumberGenerator().generate();
	}
}
