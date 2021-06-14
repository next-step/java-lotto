package com.nextstep.lotto;

import java.util.List;
import java.util.Set;

import com.nextstep.lotto.lotto.Lotto;
import com.nextstep.lotto.lotto.LottoFactory;
import com.nextstep.lotto.lotto.LottoNumber;
import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.lotto.RandomNumberGenerator;
import com.nextstep.lotto.lotto.WinningLotto;
import com.nextstep.lotto.result.LottoResult;
import com.nextstep.lotto.store.LottoStore;

public class LottoMain {

	public static void main(String[] args) {
		LottoInput lottoInput = new LottoInput();
		LottoOutput lottoOutput = new LottoOutput();
		LottoFactory lottoFactory = new LottoFactory(new RandomNumberGenerator());

		lottoOutput.printMoneyForLotto();
		int money = lottoInput.inputMoney();

		lottoOutput.printManualLottoCount();
		int manualLottoCount = lottoInput.inputManualLottoCount();

		LottoStore lottoStore = new LottoStore(money, manualLottoCount);

		lottoOutput.printManualLottoInput(lottoStore.manualLottoCount());

		List<Lotto> lottoList = lottoInput.inputManualLotto(lottoStore.manualLottoCount());
		Lottos lottos = new Lottos(lottoList);
		lottos.add(lottoFactory.create(lottoStore.autoLottoCount()));

		lottoOutput.printLottoCount(lottoStore);
		lottoOutput.printLottos(lottos);

		lottoOutput.printWinningNumber();
		Set<LottoNumber> winningNumbers = lottoInput.inputNumber();
		lottoOutput.printBonusNumber();
		LottoNumber bonusNumber = lottoInput.inputBonusNumber();
		Lotto winning = new Lotto(winningNumbers);
		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		LottoResult lottoResult = lottos.matchRank(winningLotto);
		lottoOutput.printStatistics(lottoResult);
		lottoOutput.printRevenueRatio(lottoResult.revenueRatio(money));
	}
}
