package step3;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Result {

	private final Lottos lottos;
	private final Map<Operator, Integer> map = new TreeMap<>(){{
		put(Operator.THREE, 0);
		put(Operator.FOUR, 0);
		put(Operator.FIVE, 0);
		put(Operator.FIVE_BONUS, 0);
		put(Operator.SIX, 0);
	}};

	public Result(Lottos lottos) {
		this.lottos = lottos;
	}

	public List<Set<Integer>> lottoList() {
		return lottos.getLottos();
	}

	public Map<Operator, Integer> results(Set<Integer> winningNumbers, int bonus) {
		for (Set<Integer> lottos : lottoList()) {
			result(lottos, winningNumbers, bonus);
		}
		return map;
	}

	private void result(Set<Integer> lottos, Set<Integer> winningNumbers, int bonus) {
		Operator rank = Operator.find(checkRank(lottos, winningNumbers, bonus));
		if (rank == null) {
			return;
		}
		map.put(rank, map.get(rank) + 1);
	}

	private int checkRank(Set<Integer> lottos, Set<Integer> winningNumbers, int bonus) {
		return this.lottos.results(lottos, winningNumbers, bonus);
	}
}
