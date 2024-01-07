package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public final class LottoApplicaion {
	public static void main(String[] args) {
		int price = priceInput();
		int manualCount = manualCount();
		Lottos entireLotto = new Lottos();
		entireLotto.addManualLotto(manualNumbers(manualCount));

		int count = numberOfLotto(price, manualCount);
		entireLotto.addAutoLotto(count - manualCount);
		printEntireLotto(entireLotto);

		winningNumber();
		Lotto winningNumbers = Lotto.of(winningNumbers(inputText()));
		LottoNumber bonusNumber = LottoNumber.of(bonusNumber());
		LottoResult lottoResult = new WinningLotto(winningNumbers, bonusNumber).match(entireLotto);
		printStatistics(lottoResult, price);
	}
}
