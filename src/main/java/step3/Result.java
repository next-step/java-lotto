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
		put(Operator.SIX, 0);
	}};

	public Result(Lottos lottos) {
		this.lottos = lottos;
	}

	public List<Set<Integer>> getList() {
		return lottos.getLottos();
	}

	public Map<Operator, Integer> results(Set<Integer> winningNumbers) {
		for (Set<Integer> lottos : getList()) {
			result(lottos, winningNumbers);
		}
		return map;
	}

	private void result(Set<Integer> lottos, Set<Integer> winningNumbers) {
		Operator rank = Operator.find(checkRank(lottos, winningNumbers));
		if (rank == null) {
			return;
		}
		map.put(rank, map.get(rank) + 1);
	}

	private int checkRank(Set<Integer> lottos, Set<Integer> winningNumbers) {
		return this.lottos.results(lottos, winningNumbers);
	}
}
