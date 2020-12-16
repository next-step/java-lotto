package lotto;

import lotto.number.LottoNumbers;

import java.util.List;

public interface LottoView {
	void showBuyLottoNumbers(List<LottoNumbers> lottoNumbersList);

	void showStatistics(LottoStatistics lottoStatistics);
}
