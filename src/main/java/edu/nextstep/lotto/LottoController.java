package edu.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;

import edu.nextstep.lotto.domain.LottoGame;
import edu.nextstep.lotto.domain.sub.LottoNumber;
import edu.nextstep.lotto.domain.sub.LottoNumbers;
import edu.nextstep.lotto.domain.Money;
import edu.nextstep.lotto.util.NumberUtil;
import edu.nextstep.lotto.view.InputView;
import edu.nextstep.lotto.view.ResultView;

public class LottoController {
	public void play() {
		Money money = new Money(InputView.inputMoney());
		int numberOfPurchase = money.howManyPurchase();

		ResultView.printHowManyPurchase(numberOfPurchase);

		List<List<Integer>> purchasedLottoNumbersList = getRandomLottoNumbersList(numberOfPurchase);
		ResultView.printLottos(purchasedLottoNumbersList);

		List<Integer> winningNumbers = InputView.inputWinningNumbers();
		LottoGame lottoGame = new LottoGame(purchasedLottoNumbersList, winningNumbers);

		ResultView.printWinningStatistics(lottoGame.getResultAsCountingMap());
		ResultView.printProfitRatio(lottoGame.getProfitRatio());
	}

	protected List<List<Integer>> getRandomLottoNumbersList(int size) {
		List<List<Integer>> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lottoNumbers.add(getRandomLottoNumbers());
		}
		return lottoNumbers;
	}

	private List<Integer> getRandomLottoNumbers() {
		return NumberUtil.generateSortedRandomNumber(LottoNumber.START_LIMIT, LottoNumber.END_LIMIT, LottoNumbers.SIZE);
	}
}