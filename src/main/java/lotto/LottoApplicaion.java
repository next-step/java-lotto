package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printNumberOfLotto(price);
		List<Lotto> entireLotto = Lotto.lottoFactory(count);
		printEntireLotto(entireLotto);

		printWinningNumber();
		Lotto winningNumbers = new Lotto(winningNumbers(inputText()));
		LottoResult lottoResult = new LottoResult(winningNumbers.match(entireLotto));
		printStatistics(lottoResult, price);
	}
}
