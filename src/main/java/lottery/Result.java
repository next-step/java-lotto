package lottery;

public class Result {

	private final LotteryMatchTypeMap resultMap;

	public Result() {
		resultMap = LotteryMatchTypeMap.newInstance();
	}

	public LotteryMatchTypeMap getResultMap() {
		return resultMap;
	}

	public float getTotalYield(Money buyerMoney) {
		Money totalMoney = getTotalMoney();
		return totalMoney.divideWithFloating(buyerMoney);
	}

	private Money getTotalMoney() {
		return resultMap.getTotalMoney();
	}
}
