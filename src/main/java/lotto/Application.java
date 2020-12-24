package lotto;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
	public static void main(String[] args) {
		int money = ConsoleInputView.inputPurchaseMoney();

		Lottos lottos = LottoStore.buy(money);
		ConsoleOutputView.showLottos(lottos);

		List<Integer> numbers = ConsoleInputView.inputWonLottoNumbers();

		LottoResults lottoResults = lottos.compareResult(Lotto.of(numbers));
		ConsoleOutputView.showLottoResults(lottoResults, money);
	}
}
