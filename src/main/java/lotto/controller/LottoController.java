package lotto.controller;

import lotto.domain.lotto.*;
import lotto.domain.lotto.policy.RandomLottoNumberGenerator;
import lotto.domain.lotto.policy.SelfLottoNumberGenerator;
import lotto.domain.person.Person;
import lotto.dto.InputLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	public static void buyLottoAndLookUpPrizes() {
		Person person = Person.of(InputView.receiveAmount());
		int selfBuyCount = InputView.receiveSelfBuyCount();
		for (InputLottoNumbers inputLottoNumbers : InputView.receiveSelfLottoNumbers(selfBuyCount)) {
			person.buyLottoSelf(LottoCreator.of(new SelfLottoNumberGenerator(inputLottoNumbers.getInputNumbers()), LottoType.SELF));
		}

		// buyLotto
		person.buyLottoWithAllMoney(LottoCreator.of(new RandomLottoNumberGenerator(), LottoType.AUTO));
		ResultView.printBuyingLotteries(person.getLottoDtoCollection());

		// LookUpPrizes
		LottoPrizes lottoPrizes = person.checkAllLotteries(InputView.receiveAnswerNumbers(), InputView.receiveBonusNumber());
		ResultView.printWinStats(lottoPrizes.createStatistics(), lottoPrizes.calculateEarningsRatio(LottoCreator.LOTTO_PRICE));
	}

}
