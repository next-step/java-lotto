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
		int price = priceInput();
		int manualCount = manualCount();
		List<Lotto> entireLotto = Lotto.initializeEntireLotto(manualNumbers(manualCount));

		int count = numberOfLotto(price, manualCount);
		entireLotto.addAll(Lotto.autoLottoFactory(count-manualCount));
		printEntireLotto(entireLotto);

		winningNumber();
		Lotto winningNumbers = new Lotto(winningNumbers(inputText()));
		LottoNumber bonusNumber = new LottoNumber(bonusNumber());
		LottoResult lottoResult = new LottoResult(new WinningLotto(winningNumbers, bonusNumber).match(entireLotto));
		printStatistics(lottoResult, price);
	}
}
