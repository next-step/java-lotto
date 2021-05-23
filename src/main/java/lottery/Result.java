package lottery;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

	public static final Result NONE = new Result();
	private final Map<LotteryMatchType, Integer> resultMap = new LinkedHashMap<>();

	private Money totalMoney = Money.won(0L);

	public Result() {
		resultMap.put(LotteryMatchType.THREE_MATCH, 0);
		resultMap.put(LotteryMatchType.FOUR_MATCH, 0);
		resultMap.put(LotteryMatchType.FIVE_MATCH, 0);
		resultMap.put(LotteryMatchType.SIX_MATCH, 0);
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

	public Map<LotteryMatchType, Integer> getTotalMatchNumber() {
		return resultMap;
	}

	public Money getTotalMoney() {
		resultMap.forEach(
			(match, count) -> totalMoney = totalMoney.add(match.money().multiply(count))
		);
		return totalMoney;
	};

	public float getTotalYield(Money buyerMoney){
		Money totalMoney = getTotalMoney();
		return totalMoney.divideWithFloating(buyerMoney);
	}
}
