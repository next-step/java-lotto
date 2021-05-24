package lottery;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

	public static final Result NONE = new Result();
	private final Map<LotteryMatchType, Integer> resultMap = new LinkedHashMap<>();

	private Money totalMoney = Money.won(0L);

	public Result() {
	}

	public void addMatchType(LotteryMatchType match) {
		resultMap.merge(match, 1, Integer::sum);
	}

	public int getThreeMatchNumber() {
		return resultMap.get(LotteryMatchType.THREE_MATCH);
	}

	public int getFourMatchNumber() {
		return resultMap.get(LotteryMatchType.FOUR_MATCH);
	}

	public int getFiveMatchNumber() {
		return resultMap.get(LotteryMatchType.FIVE_MATCH);
	}

	public int getSixMatchNumber() {
		return resultMap.get(LotteryMatchType.SIX_MATCH);
	}

	public Map<LotteryMatchType, Integer> getTotalMatchMap() {
		return resultMap;
	}

	public float getTotalYield(Money buyerMoney) {
		return getTotalMoney().divideWithFloating(buyerMoney);
	}

	private Money getTotalMoney() {
		totalMoney = Money.won(0L);

		resultMap.forEach(
			(match, count) -> totalMoney = totalMoney.add(match.money().multiply(count))
		);
		return totalMoney;
	}
}
