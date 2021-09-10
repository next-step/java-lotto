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
		System.out.println("3개 일치 (5000원)-" + (rankMap.get(Rank.FIFTH) == null ? INIT_NUMBER : rankMap.get(Rank.FIFTH)));
		System.out.println("4개 일치 (50000원)-" + (rankMap.get(Rank.FOURTH) == null ? INIT_NUMBER : rankMap.get(Rank.FOURTH)));
		System.out.println("5개 일치 (1500000원)-" + (rankMap.get(Rank.THIRD) == null ? INIT_NUMBER : rankMap.get(Rank.THIRD)));
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + (rankMap.get(Rank.SECOND) == null ? INIT_NUMBER : rankMap.get(Rank.SECOND)));
		System.out.println("6개 일치 (2000000000원)-" + (rankMap.get(Rank.FIRST) == null ? INIT_NUMBER : rankMap.get(Rank.FIRST)));

		int sum = INIT_NUMBER;
		System.out.println("총 수익률은 " + sum + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
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
