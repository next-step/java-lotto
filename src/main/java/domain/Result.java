package domain;

import java.util.List;

public class Result {

	private static final Integer CONTAINER_SIZE = 7;
	private static final Integer FIRST = 1;
	private static final Integer SECOND = 2;
	private static final Integer THIRD = 3;
	private static final Integer FOURTH = 4;
	private static final Integer FIFTH = 5;

	private int[] resultContainer;

	public Result() {
		resultContainer = new int[CONTAINER_SIZE];
	}

	public void viewResult(List<Rank> container) {
		firstComment();
		calculateStatistics(container);
		System.out.println("3개 일치 (5000원)-" + resultContainer[FIFTH]);
		System.out.println("4개 일치 (50000원)-" + resultContainer[FOURTH]);
		System.out.println("5개 일치 (1500000원)-" + resultContainer[THIRD]);
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + resultContainer[SECOND]);
		System.out.println("6개 일치 (2000000000원)-" + resultContainer[FIRST]);

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
