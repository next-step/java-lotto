package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import lotto.domain.LottoBalls;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	public List<LottoBalls> createLottoBalls(ResultView resultView, int lottoCount) {
		List<LottoBalls> lottoBallsList = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			lottoBallsList.add(LottoBalls.createRandomNumber());
		}
		resultView.outputLottoLotteries(lottoBallsList);
		return lottoBallsList;
	}

	public Map<Integer, Integer> proceedStatistics(InputView inputView, List<LottoBalls> lottoBallsList) {
		int[] winnerNumbers = Stream.of(inputView.inputInputLastWeekWinnerNumbers().split(","))
			.mapToInt(s -> Integer.parseInt(s.trim()))
			.toArray();
		return LottoUtil.getLottoStatistics(lottoBallsList, winnerNumbers);
	}

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		LottoController lottoController = new LottoController();

		int lottoCount = inputView.inputLottoBuyAmount() / 1000;
		List<LottoBalls> lottoBallsList = lottoController.createLottoBalls(resultView, lottoCount);

		Map<Integer, Integer> winStatistics = lottoController.proceedStatistics(inputView, lottoBallsList);

		resultView.outputStatistics(winStatistics, LottoUtil.getRateOfReturn(lottoCount, winStatistics));
		inputView.scannerClose();
	}

}
