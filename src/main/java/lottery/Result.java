package lottery;

import java.util.Collections;
import java.util.Map;

public class Result {

	private final LotteryMatchTypeMap resultMap;

	public Result(LotteryMatchTypeMap resultMap) {
		this.resultMap = resultMap;
	}

	public Map<LotteryMatchType, Integer> getResultMap() {
		return Collections.unmodifiableMap(resultMap.getMatchTypeMap());
	}

	public float getTotalYield(Money buyerMoney) {
		Money totalMoney = getTotalMoney();
		return totalMoney.divideWithFloating(buyerMoney);
	}

	private Money getTotalMoney() {
		return resultMap.getTotalMoney();
	}
}
