package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
	public static void start() {
		long lottoMoney = InputView.inputLottoMoney();
		int lottoCount = LottoCalculator.getAvailableLottoNumbers(lottoMoney);

		int manualLottoCount = InputView.inputManualLottoNumberCount();

		checkLottoCount(lottoCount, manualLottoCount);

		List<List<Integer>> inputManualLottos = InputView.inputManualLottoNumber(manualLottoCount);

		ResultView.printLottoCount(manualLottoCount, lottoCount - manualLottoCount);

		List<LottoNumbers> mergedLottos = getMergedLottos(getManualLottos(inputManualLottos), getAutoLottoNumbers(lottoCount));

		Lottos lottos = new Lottos(mergedLottos);

		ResultView.printLottos(lottos);

		List<Integer> winningLottoNumber = InputView.inputWinningNumber();
		LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

		WinningLottoNumber bonusLottoNumber = new WinningLottoNumber(new LottoNumbers(winningLottoNumber), bonusNumber);

		Map<LottoRank, Integer> lottoRanks = lottos.getWinningStatistics(bonusLottoNumber);

		ResultView.printWinningStatistics(lottoRanks);
		ResultView.printRateOfReturn(LottoCalculator.getRateOfReturn(lottoMoney, getWinningMoney(lottoRanks)));
	}

	private static void checkLottoCount(int lottoCount, int manualLottoCount) {
		if (lottoCount < manualLottoCount)
			throw new IllegalArgumentException("수동으로 구매하는 로또 수가 구매 금액보다 크면 안됩니다.");
	}

	private static List<LottoNumbers> getAutoLottoNumbers(int lottoCount) {
		return Stream.generate(() -> LottoShuffle.makeLottoNumbersInRange())
				.limit(lottoCount)
				.collect(Collectors.toList());
	}

	private static List<LottoNumbers> getManualLottos(List<List<Integer>> inputManualLottos) {
		return inputManualLottos.stream()
				.map(LottoNumbers::new)
				.collect(Collectors.toList());
	}

	private static List<LottoNumbers> getMergedLottos(List<LottoNumbers> autoLottoNumbers, List<LottoNumbers> manualLottos) {
		return Stream.of(autoLottoNumbers, manualLottos)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	private static long getWinningMoney(Map<LottoRank, Integer> lottoRanks) {
		return lottoRanks.entrySet().stream().map(lottoRank -> lottoRank.getKey().getWinningMoney()).reduce(Integer::sum).orElse(0);
	}

}
