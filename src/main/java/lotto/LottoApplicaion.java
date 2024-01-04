package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = printPriceInput();
		int count = printNumberOfLotto(price);
		List<Lotto> entireLotto = Lotto.lottoFactory(count);
		printEntireLotto(entireLotto);

		printWinningNumber();
		Lotto winningNumbers = new Lotto(winningNumbers(inputText()));
		LottoNumber bonusNumber = new LottoNumber(printBonusNumber());
		LottoResult lottoResult = new LottoResult(new WinningLotto(winningNumbers, bonusNumber).match(entireLotto));

		printStatistics(lottoResult, price);
	}
}
