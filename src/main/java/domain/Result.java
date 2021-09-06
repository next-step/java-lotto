package domain;

public class Result {

	private static final Integer THREE = 3;
	private static final Integer FOUR = 4;
	private static final Integer FIVE = 5;
	private static final Integer SIX = 6;

	public void viewResult(int[] container) {
		firstComment();
		System.out.println("3개 일치 (5000원)-" + container[THREE]);
		System.out.println("4개 일치 (50000원)-" + container[FOUR]);
		System.out.println("5개 일치 (1500000원)-" + container[FIVE]);
		System.out.println("6개 일치 (2000000000원)-" + container[SIX]);

//		int Sum = Rank.rank(THREE).getAmount() * container[THREE]
//						+ Rank.rank(FOUR).getAmount() * container[FOUR]
//						+ Rank.rank(FIVE).getAmount() * container[FIVE];

		int sum = 0;
		System.out.println("총 수익률은 " + sum + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
	}

	public void viewLotto(Lotto lotto) {
		System.out.println(lotto);
	}

	private void firstComment() {
		System.out.println("당첨 통계");
		System.out.println("----------");
	}
}
