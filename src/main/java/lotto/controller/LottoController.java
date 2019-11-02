package lotto.controller;

import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoPrize;
import lotto.domain.lotto.RandomLottoNumberGenerator;
import lotto.domain.util.EarningsRateCalculator;
import lotto.domain.person.Person;
import lotto.domain.util.LottoPrizeCounter;
import lotto.dto.LottoPrizeStat;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

	/**
	 * TODO 인스턴스 변수를 사용하지 않고 메소드의 길이를 줄일 수 있는 방법이 있을지 생각해보기
	 */

	public static void buyLottoAndLookUpPrizes() {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		// buyLotto
		Person person = Person.of(inputView.receiveAmount());
		person.buyLottoWithAllMoney(LottoCreator.of(new RandomLottoNumberGenerator()));
		resultView.printBuyingLotteries(person.getLottoDtos());

		// LookUpPrizes
		List<LottoPrize> lottoPrizes = person.checkAllLotteries(inputView.receiveAnswerNumbers());
		LottoPrizeStat lottoPrizeStat = LottoPrizeCounter.countLottoPrizes(lottoPrizes);
		double earningsRatio = EarningsRateCalculator.calculate(lottoPrizes, LottoCreator.LOTTO_PRICE);
		resultView.printWinStats(lottoPrizeStat, earningsRatio);
	}

}
