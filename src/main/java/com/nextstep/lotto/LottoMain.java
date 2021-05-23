package com.nextstep.lotto;

import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.lotto.WinningLotto;
import com.nextstep.lotto.result.RevenueRatio;
import com.nextstep.lotto.result.Statistics;
import com.nextstep.lotto.store.LottoStore;

public class LottoMain {

	public static void main(String[] args) {

		LottoInput lottoInput = new LottoInput();
		int money = lottoInput.inputMoney();
		LottoStore lottoStore = new LottoStore(money);

		Lottos lottos = new Lottos(lottoStore.lottoCount());
		lottos.print();

		String winningNumbers = lottoInput.inputWinningNumber();
		WinningLotto winningLotto = new WinningLotto(winningNumbers);

		Statistics statistics = new Statistics(winningLotto, lottos);
		statistics.generateLottoResult();
		statistics.print();

		RevenueRatio revenueRatio = new RevenueRatio(money, statistics.getLottoResult().lottoMatches());
		revenueRatio.print();
	}
}
