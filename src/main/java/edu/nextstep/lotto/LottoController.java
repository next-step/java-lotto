package edu.nextstep.lotto;

import edu.nextstep.lotto.domain.Money;
import edu.nextstep.lotto.view.InputView;
import edu.nextstep.lotto.view.ResultView;

public class LottoController {
	public void play() {
		Money money = new Money(InputView.inputMoney());
		ResultView.printHowManyPurchase(money.howManyPurchase());
	}
}