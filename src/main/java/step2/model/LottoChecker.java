package step2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

	private final Lottos lottos;
	private final Money money;

	public LottoChecker(final Lottos lottos, final Money money) {
		this.lottos = lottos;
		this.money = money;
	}

	public Map<Integer, Integer> checkHit(final List<Integer> hitNumber) {
		Map<Integer, Integer> hitMap = new HashMap<>();
		lottos.getLottos().stream()
				.mapToInt(lotto -> lotto.checkHit(hitNumber))
				.forEachOrdered(hitCnt ->
						hitMap.put(hitCnt, hitMap.containsKey(hitCnt) ? hitMap.get(hitCnt) + 1 : 1));
		return hitMap;
	}

	public double getEarningRate(Map<Integer, Integer> hitCntMap) {
		int prizeMoney = 0;
		for (int cnt : hitCntMap.keySet()) {
			prizeMoney += Awards.findAward(cnt).getAward() * hitCntMap.get(cnt);
		}

		return (double) prizeMoney / money.getMoney();
	}
}
