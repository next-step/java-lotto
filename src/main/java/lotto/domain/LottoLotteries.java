package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.utils.ValidationUtils;

public class LottoLotteries {
	private final List<LottoLottery> lottoLotteries;

	public LottoLotteries(List<LottoLottery> lottoLotteries) {
		ValidationUtils.validateEmpty(lottoLotteries);
		this.lottoLotteries = Collections.unmodifiableList(lottoLotteries);
	}

	public int getCount() {
		return lottoLotteries.size();
	}

	public List<LottoLottery> getLottoLotteries() {
		return lottoLotteries;
	}
}
