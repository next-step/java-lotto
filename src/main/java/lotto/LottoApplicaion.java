package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

import lotto.controller.LottoGenerator;
import lotto.controller.Statistics;
import lotto.controller.WinningNumberChecker;
import lotto.domain.Digit;
import lotto.domain.Digits;
import lotto.domain.Lottos;

public class LottoApplicaion {
	public static void main(String[] args) {
		printPriceInput();
		int price = inputInt();
		int count = printPrice(price);
		List<Lottos> lottosList = LottoGenerator.generate(count);
		printLottoNumber(lottosList);
		printWinningNumber();
		List<Digit> winningNumbers = Digits.create(winningNumbers(inputText()));
		int[] statistics = Statistics.calculate(WinningNumberChecker.check(winningNumbers, lottosList, count));
		printStatistics(statistics, Statistics.calculateRateOfReturn(statistics, price));
	}
}
