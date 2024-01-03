package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

import lotto.domain.Lotto;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printPrice(price);
		List<Lotto> entireLotto = Lotto.lottoFactory(count);
		printEntireLotto(entireLotto);

		printWinningNumber();

	}
}
