package lotto.controller;

import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoPrizes;
import lotto.domain.lotto.RandomLottoNumberGenerator;
import lotto.domain.person.Person;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	public static void buyLottoAndLookUpPrizes() {

		Person person = Person.of(InputView.receiveAmount());

		// buyLotto
		person.buyLottoWithAllMoney(LottoCreator.of(new RandomLottoNumberGenerator()));
		ResultView.printBuyingLotteries(person.getLottoDtos());

		// LookUpPrizes
		LottoPrizes lottoPrizes = person.checkAllLotteries(InputView.receiveAnswerNumbers(),
				InputView.receiveBonusNumber());
		ResultView.printWinStats(lottoPrizes.createStatistics(),
				lottoPrizes.calculateEarningsRatio(LottoCreator.LOTTO_PRICE));
	}

}
