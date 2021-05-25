package lotto.game.domain.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.code.PrizeCode;
import lotto.game.exception.IllegalGameException;

public class GameWinningCondition {
	private static final int INITIALIZE_VALUE_ZERO = 0;

	private final Game gameCondition;

	private GameWinningCondition(Game customGame) {
		this.gameCondition = customGame;
	}

	public static void validateGenerate(Game customGame) throws IllegalGameException {
		validateNotNullOrNotEmpty(customGame);
	}

	private static void validateNotNullOrNotEmpty(Game customGame) throws IllegalGameException {
		if (isNullOrEmpty(customGame)) {
			throw new IllegalGameException("전달 받은 정보가 null 또는 비어있는 값입니다. 당첨 정보가 들어 있는 게임 정보를 전달해주시기 바랍니다.");
		}
	}

	private static boolean isNullOrEmpty(Game customGame) {
		return customGame == null || customGame.ballGroup() == null
			|| customGame.ballGroup().balls() == null || customGame.ballGroup().balls().isEmpty();
	}

	public static GameWinningCondition generate(Game customGame) throws IllegalGameException {
		validateGenerate(customGame);
		return new GameWinningCondition(customGame);
	}

	public int calculateContainWinningBalls(Game boughtGame) {
		List<Ball> boughtBalls = boughtGame.ballGroup().balls();
		return (int) this.gameCondition.ballGroup().balls().stream()
			.filter(boughtBalls::contains)
			.count();
	}

	public String makeMsgWinningStatistics(GameGroup gameGroup) {
		Map<PrizeCode, Integer> winningStatistics = makeWinningStatisticsMap(gameGroup);
		String earningRate = calculateEarningRate(winningStatistics, gameGroup);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("당첨 통계\n---------\n");
		for (PrizeCode thisPrize : PrizeCode.values()) {
			stringBuilder.append(makeMsgWinningAmount(thisPrize, winningStatistics.get(thisPrize)));
		}
		stringBuilder.append("총 수익률은 " + earningRate + "입니다.\n");
		return stringBuilder.toString();
	}

	private String makeMsgWinningAmount(PrizeCode thisPrize, int numberOfPrize) {
		if (thisPrize.isNothing()) {
			return "";
		}
		return String.format("%d개 일치 (%d원)- %d개\n", thisPrize.countOfMatch(), thisPrize.winningAmount(), numberOfPrize);
	}

	private String calculateEarningRate(Map<PrizeCode, Integer> winningStatistics, GameGroup gameGroup) {
		BigDecimal numerator = calculateNumeratorOfEarningRate(winningStatistics);
		BigDecimal denominator = BigDecimal.valueOf(gameGroup.games().size() * Money.GAME_FEE);
		double earningRate = numerator.divide(denominator, 2, RoundingMode.FLOOR).doubleValue();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return decimalFormat.format(earningRate);
	}

	private BigDecimal calculateNumeratorOfEarningRate(Map<PrizeCode, Integer> winningStatistics) {
		BigDecimal result = BigDecimal.valueOf(INITIALIZE_VALUE_ZERO);
		for (PrizeCode thisPrize : PrizeCode.values()) {
			int countOfPrize = winningStatistics.get(thisPrize);
			int winningAmount = thisPrize.winningAmount();
			BigDecimal subResult = BigDecimal.valueOf(countOfPrize).multiply(BigDecimal.valueOf(winningAmount));
			result = result.add(subResult);
		}
		return result;
	}

	private Map<PrizeCode, Integer> makeWinningStatisticsMap(GameGroup gameGroup) {
		Map<PrizeCode, Integer> resultMap = initializeResultHashMap();
		for (Game boughtGame : gameGroup.games()) {
			int matchCounts = calculateContainWinningBalls(boughtGame);
			PrizeCode prizeCode = PrizeCode.findCode(matchCounts);
			plusCountMatchCounts(resultMap, prizeCode);
		}
		return resultMap;
	}

	private void plusCountMatchCounts(Map<PrizeCode, Integer> resultMap, PrizeCode prizeCode) {
		resultMap.put(prizeCode, resultMap.get(prizeCode) + 1);
	}

	private Map<PrizeCode, Integer> initializeResultHashMap() {
		Map<PrizeCode, Integer> resultMap = new HashMap<>();
		for (PrizeCode prizeCode : PrizeCode.values()) {
			resultMap.put(prizeCode, INITIALIZE_VALUE_ZERO);
		}
		return resultMap;
	}

	public boolean isSameWinningCondition(GameWinningCondition gameWinningCondition) {
		List<Ball> thisBalls = this.gameCondition.ballGroup().balls();
		List<Ball> compareBalls = gameWinningCondition.gameCondition.ballGroup().balls();
		return thisBalls.containsAll(compareBalls) && compareBalls.containsAll(thisBalls);
	}

}
