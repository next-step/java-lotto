package lotto.application;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLotteriesFactory;
import lotto.domain.LottoLottery;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinLottoNumbers;

public class LottoService {
	private final RandomLottoNumberGenerator randomLottoNumberGenerator;
	private final LottoLotteries lottoLotteries;

	public LottoService(Money money) {
		this.lottoLotteries = buyMaxAutoLottoLotteries(money);
		this.randomLottoNumberGenerator = new RandomLottoNumberGenerator();
	}

	public LottoLotteries buyMaxAutoLottoLotteries(Money money) {
		int count = money.buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE);

		return buyAutoLottoLotteries(count);
	}

	private LottoLotteries buyAutoLottoLotteries(int count) {
		return LottoLotteriesFactory.createAutoLottoLotteries(count, randomLottoNumberGenerator);
	}

	public LottoLotteries getLottoLotteries() {
		return lottoLotteries;
	}

	public LottoResults getLottoResults(WinLottoNumbers winLottoNumbers) {
		return lottoLotteries.getLottoResults(winLottoNumbers);
	}
}
