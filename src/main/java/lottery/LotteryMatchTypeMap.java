package lottery;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LotteryMatchTypeMap {

	public static final LotteryMatchTypeMap EMPTY = new LotteryMatchTypeMap(new LinkedHashMap<>());

	private final Map<LotteryMatchType, Integer> matchTypeMap;

	private LotteryMatchTypeMap(Map<LotteryMatchType, Integer> matchTypeMap) {
		this.matchTypeMap = matchTypeMap;
	}

	public static LotteryMatchTypeMap of(Map<LotteryMatchType, Integer> map) {
		return new LotteryMatchTypeMap(map);
	}

	public Map<LotteryMatchType, Integer> getMatchTypeMap() {
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
