package lotto;

import java.util.List;

import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.dto.PurchaseCountDto;

public class LotteryApp {

	public static void main(String[] args) {
		final InputView inputView = new InputView();
		final ResultView resultView = new ResultView();
		final LotteryMachine lotteryMachine = new LotteryMachine();

		int moneyValue = inputView.askMoney();
		Money money = new Money(moneyValue);

		List<Lotto> lottos = lotteryMachine.issue(money);
		PurchaseCountDto purchaseCountDto = PurchaseCountDto.of(lottos.size());
		resultView.printPurchaseCount(purchaseCountDto);
	}
}
