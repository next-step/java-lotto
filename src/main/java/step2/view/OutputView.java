package step2.view;

import static step2.model.Rank.SECOND;
import static step2.model.Rank.THIRD;

import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.Rank;

public class OutputView {

	private static final int DEFAULT_COUNT = 0;
	private static final int BENEFIT_STANDARD = 1;
	private static final int MIN_MATCH = 3;
	private static final int MAX_MATCH = 6;

	public void resultView(HashMap<Rank, Integer> totalCount, int bonusMatchCount) {
		System.out.println("당첨 통계");
		System.out.println("--------");
		for (int i = MIN_MATCH; i <= MAX_MATCH; i++) {
			showResult(Rank.of(i), bonusMatchCount, totalCount);
		}
	}

	private void showResult(Rank rank, int bonusMatchCount, HashMap<Rank, Integer> totalCount) {

		if (rank == SECOND) {
			rankSecondMessage(bonusMatchCount, totalCount.get(rank));
			return;
		}

		System.out.printf("%s개 일치" + "(%d)- " + totalCount.get(rank) + "개\n",
			rank.getCountOfMatch(),
			rank.getWinningMoney());
	}

	public void showTotalTicket(int tickets) {
		System.out.println(tickets + "매를 구매했습니다");
	}

	public void showLotteries(int tickets, Lotteries lotteries) {
		for (int i = DEFAULT_COUNT; i < tickets; i++) {
			System.out.println(lotteries.showLotteries(i).getLotto());
		}
	}

	public void showRate(double rate) {
		defaultMessage(rate);
		if (isProfit(rate)) {
			return;
		}
		System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임");
	}

	private boolean isProfit(double rate) {
		return rate > BENEFIT_STANDARD;
	}

	private void defaultMessage(double rate) {
		System.out.println("수익률은 " + String.format("%.2f", rate) + "입니다");
	}

	private void rankSecondMessage(int countOfBonus, int countOfMatch) {
		System.out.printf(
			"%s개 일치" + "(%d)- " + (countOfMatch - countOfBonus) + "개\n",
			SECOND.getCountOfMatch(), SECOND.getWinningMoney());

		System.out.printf("%s개 일치,보너스 볼 일치" + "(%d)- " + countOfBonus + "개\n",
			SECOND.getCountOfMatch(), SECOND.getWinningMoney());
	}

}
