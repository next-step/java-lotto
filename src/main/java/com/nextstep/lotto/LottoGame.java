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

public class LottoGame {
	private final LottoInput lottoInput = new LottoInput();
	private final LottoOutput lottoOutput = new LottoOutput();
	private final LottoFactory lottoFactory = new LottoFactory(new RandomNumberGenerator());

	public void start() {
		lottoOutput.printMoneyForLotto();
		int money = lottoInput.inputMoney();

		LottoStore lottoStore = makeLottoStore(money);
		lottoOutput.printManualLottoInput(lottoStore.manualLottoCount());

		Lottos lottos = makeLottos(lottoStore);
		lottoOutput.printLottoCount(lottoStore);
		lottoOutput.printLottos(lottos);

		WinningLotto winningLotto = makeWinningLotto();

		LottoResult lottoResult = lottos.matchRank(winningLotto);
		lottoOutput.printStatistics(lottoResult);
		lottoOutput.printRevenueRatio(lottoResult.revenueRatio(money));
	}

	private LottoStore makeLottoStore(int money) {
		int manualLottoCount = inputManualLottoCount();
		return new LottoStore(money, manualLottoCount);
	}

	private Lottos makeLottos(LottoStore lottoStore) {
		List<Lotto> lottoList = lottoInput.inputManualLotto(lottoStore.manualLottoCount());
		Lottos lottos = new Lottos(lottoList);

		lottos.add(lottoFactory.create(lottoStore.autoLottoCount()));
		return lottos;
	}

	private WinningLotto makeWinningLotto() {
		Set<LottoNumber> winningNumbers = inputWinningNumbers();
		LottoNumber bonusNumber = inputBonusNumber();

		Lotto winning = new Lotto(winningNumbers);
		return new WinningLotto(winning, bonusNumber);
	}

	private int inputManualLottoCount() {
		lottoOutput.printManualLottoCount();
		return lottoInput.inputManualLottoCount();
	}

	private Set<LottoNumber> inputWinningNumbers() {
		lottoOutput.printWinningNumber();
		return lottoInput.inputNumber();
	}

	private LottoNumber inputBonusNumber() {
		lottoOutput.printBonusNumber();
		return lottoInput.inputBonusNumber();
	}
}
