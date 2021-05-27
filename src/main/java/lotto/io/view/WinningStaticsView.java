package lotto.io.view;

import java.util.HashMap;
import java.util.Map;

import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.code.PrizeCode;
import lotto.game.domain.entity.Round;
import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;

public class WinningStaticsView extends View {
	private static final int INITIALIZE_VALUE_ZERO = 0;
	private static final int NUMBER_ONE = 1;

	@Override
	public ViewCode viewCode() {
		return ViewCode.WINNING_STATICS;
	}

	@Override
	public void displayProcess(ViewStatus viewStatus, Round round, InputText inputText) {
		if (viewStatus.isFinishProcess()) {
			processWhenFinish(round);
			changeViewStatusWhenFinish(viewStatus);
		}
		changeViewStatusDefault(viewStatus);
	}

	public static View generate() {
		return new WinningStaticsView();
	}

	private void changeViewStatusDefault(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.FINISH);
	}

	private void changeViewStatusWhenFinish(ViewStatus viewStatus) {
		viewStatus.changeCurrentViewCode(ViewCode.SHUTDOWN_APPLICATION);
	}

	private void processWhenFinish(Round round) {
		printWinningStatisticsFromBoughtGames(round);
	}

	private void printWinningStatisticsFromBoughtGames(Round round) {
		printWinningStatistics(round);
	}

	private void printWinningStatistics(Round round) {
		GameGroup boughtGames = round.boughtGames();
		Map<PrizeCode, Integer> winningStatistics = makeWinningStatisticsMap(round);
		printStatisticsEachPrizeCode(winningStatistics);
		printStatisticsEarningRate(boughtGames, winningStatistics);
	}

	private void printStatisticsEarningRate(GameGroup boughtGames, Map<PrizeCode, Integer> winningStatistics) {
		String earningRate = Money.calculateEarningRate(winningStatistics, boughtGames.gamesCount());
		System.out.println("총 수익률은 " + earningRate + "입니다.\n");
	}

	private void printStatisticsEachPrizeCode(Map<PrizeCode, Integer> winningStatistics) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n당첨 통계\n---------\n");
		for (PrizeCode thisPrize : PrizeCode.values()) {
			stringBuilder.append(makeMsgWinningAmount(thisPrize, winningStatistics.get(thisPrize)));
		}
		System.out.print(stringBuilder);
	}

	private String makeMsgWinningAmount(PrizeCode thisPrize, int numberOfPrize) {
		if (thisPrize.isNothing()) {
			return "";
		}
		return String.format("%d개 일치 (%d원)- %d개\n", thisPrize.countOfMatch(), thisPrize.winningAmount(), numberOfPrize);
	}

	private Map<PrizeCode, Integer> makeWinningStatisticsMap(Round round) {
		Map<PrizeCode, Integer> resultMap = initializeResultHashMap();
		for (Game boughtGame : round.boughtGames().games()) {
			int matchCounts = boughtGame.calculateContainWinningBalls(round.gameWinningCondition());
			PrizeCode prizeCode = PrizeCode.findCode(matchCounts);
			plusCountMatchCounts(resultMap, prizeCode);
		}
		return resultMap;
	}

	private void plusCountMatchCounts(Map<PrizeCode, Integer> resultMap, PrizeCode prizeCode) {
		resultMap.put(prizeCode, resultMap.get(prizeCode) + NUMBER_ONE);
	}

	private Map<PrizeCode, Integer> initializeResultHashMap() {
		Map<PrizeCode, Integer> resultMap = new HashMap<>();
		for (PrizeCode prizeCode : PrizeCode.values()) {
			resultMap.put(prizeCode, INITIALIZE_VALUE_ZERO);
		}
		return resultMap;
	}
}
