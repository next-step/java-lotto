package step3.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoChecker {

	private final WinnerLotto winnerLotto;

	public LottoChecker(WinnerLotto winnerLotto) {
		this.winnerLotto = winnerLotto;
	}

	public int match(Lotto lotto) {
		return Awards.rank(lotto.match(winnerLotto), lotto.checkBonus(winnerLotto));
	}

	public Map<Integer, Integer> checkHitCnt(LottoList lottoList){
		Map<Integer, Integer> hitMap = IntStream.range(0, 6)
				.boxed()
				.collect(Collectors.toMap(i -> i, i -> 0, (a, b) -> b));

		lottoList.getLottoList().stream()
				.mapToInt(this::match)
				.filter(hitMap::containsKey)
				.forEachOrdered(awardRank -> hitMap.put(awardRank, hitMap.get(awardRank) + 1));

		return hitMap;
	}
}
