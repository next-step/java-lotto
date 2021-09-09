package Util;

import domain.Lotto;
import domain.Rank;

import java.util.List;

public class Result {

	private static final Integer CONTAINER_SIZE = 7;
	private final int[] resultContainer;

	public Result() {
		resultContainer = new int[CONTAINER_SIZE];
	}

	public void viewResult(List<Rank> container) {
		firstComment();
		calculateStatistics(container);
		System.out.println("3개 일치 (5000원)-" + resultContainer[Rank.FIFTH.getRanking()]);
		System.out.println("4개 일치 (50000원)-" + resultContainer[Rank.FOURTH.getRanking()]);
		System.out.println("5개 일치 (1500000원)-" + resultContainer[Rank.THIRD.getRanking()]);
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + resultContainer[Rank.SECOND.getRanking()]);
		System.out.println("6개 일치 (2000000000원)-" + resultContainer[Rank.FIRST.getRanking()]);

		int sum = 0;
		System.out.println("총 수익률은 " + sum + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
	}

	private void calculateStatistics(List<Rank> container) {
		for (int number = 0 ; number < container.size() ; ++number) {
			resultContainer[container.get(number).getRanking()]++;
		}
	}

	public void viewLotto(Lotto lotto) {
		System.out.println(lotto);
	}

	private void firstComment() {
		System.out.println("당첨 통계");
		System.out.println("----------");
	}
}
