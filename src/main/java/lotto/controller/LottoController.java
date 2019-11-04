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
	 * > 두 메소드로 분리해야하는 이유를 한 번 고민을 하면서 각 메소드들이 로직을 가진다면 컨트롤러에 로직이 있는게 맞는건가?
	 * 라는 생각이 들었습니다.
	 * 로직이 있다면 도메인으로 봐야하는게 아닌지,
	 * 그러면 컨트롤러의 역할은 어떤것인지에 대한 고민을 했었는데 고민을 하시는데 참고가 되었으면 합니다 :)
	 */

	public static void buyLottoAndLookUpPrizes() {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		// buyLotto
		Person person = Person.of(inputView.receiveAmount());
		person.buyLottoWithAllMoney(LottoCreator.of(new RandomLottoNumberGenerator()));
		resultView.printBuyingLotteries(person.getLottoDtos());

		// LookUpPrizes
		List<LottoPrize> lottoPrizes = person.checkAllLotteries(inputView.receiveAnswerNumbers(),
				inputView.receiveBonusNumber());
		LottoPrizeStat lottoPrizeStat = LottoPrizeCounter.countLottoPrizes(lottoPrizes);
		double earningsRatio = EarningsRateCalculator.calculate(lottoPrizes, LottoCreator.LOTTO_PRICE);
		resultView.printWinStats(lottoPrizeStat, earningsRatio);
	}

}
