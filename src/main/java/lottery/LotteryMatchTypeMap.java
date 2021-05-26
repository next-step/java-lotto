package lottery;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LotteryMatchTypeMap {

	private static final String NOT_FOUND_LOTTERY_MATCH_TYPE = "LotteryMatchTypeMap 정보가 없습니다";

	private Map<LotteryMatchType, Integer> matchTypeMap;

	public static LotteryMatchTypeMap of(Map<LotteryMatchType, Integer> map) {
		return new LotteryMatchTypeMap(map);
	}

	private LotteryMatchTypeMap(Map<LotteryMatchType, Integer> matchTypeMap) {
		setMatchTypeMap(matchTypeMap);
	}

	private void setMatchTypeMap(Map<LotteryMatchType, Integer> matchTypeMap) {
		if (Objects.isNull(matchTypeMap) || matchTypeMap.isEmpty()){
			throw new IllegalArgumentException(NOT_FOUND_LOTTERY_MATCH_TYPE);
		}
		this.matchTypeMap = matchTypeMap;
	}

	public Map<LotteryMatchType, Integer> matchTypeMap() {
		return Collections.unmodifiableMap(matchTypeMap);
	}

	public Money getTotalMoney() {
		Money totalMoney = Money.won(0L);
		for (LotteryMatchType matchTypeKey : matchTypeMap.keySet()) {
			Integer count = matchTypeMap.get(matchTypeKey);
			totalMoney = totalMoney.add(matchTypeKey.money().multiply(count));
		}
		return totalMoney;
	}
}
