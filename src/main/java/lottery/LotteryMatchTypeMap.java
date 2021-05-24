package lottery;

import java.util.LinkedHashMap;
import java.util.Map;

public class LotteryMatchTypeMap {

	public static final LotteryMatchTypeMap EMPTY = new LotteryMatchTypeMap(new LinkedHashMap<>());

	private final Map<LotteryMatchType, Integer> matchTypeMap;

	public static LotteryMatchTypeMap newInstance() {
		return new LotteryMatchTypeMap(new LinkedHashMap<>());
	}

	private LotteryMatchTypeMap(Map<LotteryMatchType, Integer> matchTypeMap) {
		this.matchTypeMap = matchTypeMap;
	}

	public Map<LotteryMatchType, Integer> getMatchTypeMap() {
		return matchTypeMap;
	}

	public Integer getMatchTypeCount(LotteryMatchType type){
		return matchTypeMap.getOrDefault(type, LotteryMatchType.MISS_MATCH.matchCount());
	}

	public void addMatchType(LotteryMatchType match) {
		matchTypeMap.merge(match, 1, Integer::sum);
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
