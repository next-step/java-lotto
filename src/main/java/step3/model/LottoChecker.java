package step3.model;


import java.util.Map;

public class LottoChecker {
	public static double getEarningRate(Map<Integer, Integer> hitCntMap, Money money) {
		int prizeMoney = hitCntMap.keySet().stream()
				.mapToInt(rank -> rank)
				.map(rank -> Awards.getPrize(rank, hitCntMap.get(rank)))
				.sum();
		return (double) prizeMoney / money.getMoney();
	}
}
