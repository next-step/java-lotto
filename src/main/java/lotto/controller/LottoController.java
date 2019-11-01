package lotto.controller;

import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.RandomLottoNumberGenerator;
import lotto.domain.util.EarningsRateCalculator;
import lotto.domain.person.Person;
import lotto.domain.util.LottoPrizeCounter;
import lotto.dto.LottoPrizeStat;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	private final InputView inputView;
	private final ResultView resultView;
	private Person person;

	public LottoController() {
		inputView = new InputView();
		resultView = new ResultView();
	}

	public void buyLotto() {
		person = Person.of(inputView.receiveAmount());
		LottoCreator lottoCreator = LottoCreator.of(new RandomLottoNumberGenerator());

		person.buyLottoWithAllMoney(lottoCreator);
		resultView.printBuyingLotteries(person.getLottoDtos());
	}

	public void lookUpPrizes() {
		person.checkAllLotteries(inputView.receiveAnswerNumbers());
		LottoPrizeStat lottoPrizeStat = LottoPrizeCounter.countLottoPrizes(person.getLottoDtos());
		double earningsRatio = EarningsRateCalculator.calculate(person.getLottoDtos(), LottoCreator.LOTTO_PRICE);
		resultView.printWinStats(lottoPrizeStat, earningsRatio);
	}

}
