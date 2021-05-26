package lottery;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class Result {

	private LotteryMatchTypeMap resultMap;
	private static final String NOT_FOUND_RESULTMAP_EXCEPTION_MESSAGE = "당첨을 확인할 수 있는 정보가 없습니다.";

	public Result(LotteryMatchTypeMap resultMap) {
		setResultMap(resultMap);
	}

	private void setResultMap(LotteryMatchTypeMap resultMap) {
		if (Objects.isNull(resultMap)) {
			throw new IllegalArgumentException(NOT_FOUND_RESULTMAP_EXCEPTION_MESSAGE);
		}
		this.resultMap = resultMap;
	}

	public Map<LotteryMatchType, Integer> getResultMap() {
		return Collections.unmodifiableMap(resultMap.matchTypeMap());
	}

	public float getTotalYield(Money buyerMoney) {
		Money totalMoney = getTotalMoney();
		return totalMoney.divideWithFloating(buyerMoney);
	}

	private Money getTotalMoney() {
		return resultMap.getTotalMoney();
	}
}
