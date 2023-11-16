package lotto;

import java.util.List;

public class LottoApplication {
	public static void main(String[] args) {
		LottoList lottoList = InputView.inputLottoList();
		List<Integer> winningNumbers = InputView.inputWinningNumbers();
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new Lotto(winningNumbers));

		LottoResult lottoResult = new LottoResult(lottoList);
		lottoResult.matchesWinningNumbers(lottoWinningNumbers);

		OutputView.printResultPhrase();
		OutputView.printResult(lottoResult);
	}
}
