package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

	private final List<Lotto> purchasedLottos;

	public Lottos(List<Lotto> lottos) {
		this.purchasedLottos = lottos;
	}

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public List<String> lottoStrings() {
		return purchasedLottos.stream()
			.map(Lotto::toString)
			.collect(Collectors.toList());
	}

	public int getCount() {
		return purchasedLottos.size();
	}

	public Map<Integer, Integer> getMatchingCountsMap(WinningLotto winningLotto) {
		Map<Integer, Integer> matchingCountsMap = new HashMap<>();
		for (Lotto lotto : purchasedLottos) {
			matchingCountsMap.put(
				lotto.getMatchingCount(winningLotto.getNumbers()),
				matchingCountsMap.getOrDefault(lotto.getMatchingCount(winningLotto.getNumbers()), 0) + 1
			);
		}
		return matchingCountsMap;
	}
}
