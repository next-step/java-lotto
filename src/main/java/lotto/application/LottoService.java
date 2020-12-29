package lotto.application;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLotteriesFactory;
import lotto.domain.LottoLottery;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.WinLottoNumbers;

public class LottoService {
	private final LottoNumberGenerator lottoNumberGenerator;
	private final LottoLotteries lottoLotteries;

	public LottoService(Money money, LottoNumberGenerator lottoNumberGenerator) {
		this.lottoNumberGenerator = lottoNumberGenerator;
		this.lottoLotteries = buyMaxAutoLottoLotteries(money);
	}

	public LottoLotteries buyMaxAutoLottoLotteries(Money money) {
		int count = money.buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE);

		return buyAutoLottoLotteries(count);
	}

	private LottoLotteries buyAutoLottoLotteries(int count) {
		return LottoLotteriesFactory.createAutoLottoLotteries(count, lottoNumberGenerator);
	}

	public LottoLotteries getLottoLotteries() {
		return lottoLotteries;
	}

	public LottoResults getLottoResults(WinLottoNumbers winLottoNumbers) {
		return lottoLotteries.checkLottoResults(winLottoNumbers);
	}
}
