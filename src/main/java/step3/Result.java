package step3;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Result {

	private final List<Set<Integer>> list;
	private final Map<Operator, Integer> map = new TreeMap<>(){{
		put(Operator.THREE, 0);
		put(Operator.FOUR, 0);
		put(Operator.FIVE, 0);
		put(Operator.SIX, 0);
	}};

	public Result(List<Set<Integer>> list) {
		this.list = list;
	}

	public List<Set<Integer>> getList() {
		return list;
	}

	public Map<Operator, Integer> results(Set<Integer> winningNumbers) {
		for (Set<Integer> guestLotto : list) {
			result(winningNumbers, guestLotto);
		}
		return map;
	}

	private void result(Set<Integer> winningNumbers, Set<Integer> guestLotto) {
		Operator rank = Operator.find(checkRank(guestLotto, winningNumbers));
		if (rank == null) {
			return;
		}
		map.put(rank, map.get(rank) + 1);
	}

	private int checkRank(Set<Integer> guestLotto, Set<Integer> winningNumbers) {
		int count = 0;
		Iterator<Integer> itr = winningNumbers.iterator();
		while (itr.hasNext()) {
			count = checkContains(guestLotto, count, itr);
		}
		return count;
	}

	private int checkContains(Set<Integer> guestLotto, int count, Iterator<Integer> itr) {
		if (guestLotto.contains(itr.next())) {
			count++;
		}
		return count;
	}
}
