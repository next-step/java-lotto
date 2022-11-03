package step3;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Result {

	private final Lottos lottos;
	private final Map<Operator, Integer> map = new TreeMap<>() {{
		put(Operator.NOT_RANK, 0);
		put(Operator.THREE, 0);
		put(Operator.FOUR, 0);
		put(Operator.FIVE, 0);
		put(Operator.FIVE_BONUS, 0);
		put(Operator.SIX, 0);
	}};

	public Result(Lottos lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> lottoList() {
		return lottos.getLottos();
	}

	public Map<Operator, Integer> results(Lotto winningNumbers, int bonus) {
		for (Lotto lotto : lottoList()) {
			result(lotto, winningNumbers, bonus);
		}
		return map;
	}

	private void result(Lotto lotto, Lotto winningNumbers, int bonus) {
		int count = checkRank(lotto, winningNumbers);
		Operator rank = Operator.find(count, lotto.checkBonus(bonus));
		if (rank == null) {
			return;
		}
		map.put(rank, map.get(rank) + 1);
	}

	private int checkRank(Lotto lotto, Lotto winningNumbers) {
		return this.lottos.results(lotto, winningNumbers);
	}
}
