package util;

import domain.Lotto;
import domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

	private static final Integer INIT_NUMBER = 0;
	private static final Integer RANK_COUNT_PLUS_UNIT = 1;
	private static final Map<Rank, Integer> rankMap = new HashMap<>();

	public void viewResult(List<Rank> container) {
		firstComment();
		calculateStatistics(container);
		System.out.println("3개 일치 (5000원)-" + getRankCount(Rank.FIFTH));
		System.out.println("4개 일치 (50000원)-" + getRankCount(Rank.FOURTH));
		System.out.println("5개 일치 (1500000원)-" + getRankCount(Rank.THIRD));
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + getRankCount(Rank.SECOND));
		System.out.println("6개 일치 (2000000000원)-" + getRankCount(Rank.FIRST));

		int sum = INIT_NUMBER;
		System.out.println("총 수익률은 " + sum + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
	}

	private Integer getRankCount(Rank rank) {
		if (rankMap.get(rank) == null) {
			return INIT_NUMBER;
		}
		return rankMap.get(rank);
	}

	private void calculateStatistics(List<Rank> container) {
		for (int number = INIT_NUMBER ; number < container.size() ; ++number) {
			validateRank(container.get(number));
		}
	}

	private void validateRank(Rank rank) {
		rankMap.merge(rank, RANK_COUNT_PLUS_UNIT , Integer::sum);
	}

	public void viewLotto(Lotto lotto) {
		System.out.println(lotto.toString());
	}

	private void firstComment() {
		System.out.println("당첨 통계");
		System.out.println("----------");
	}
}
