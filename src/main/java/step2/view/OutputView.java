package step2.view;

import static step2.model.Rank.SECOND;
import static step2.model.Rank.THIRD;

import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.Rank;

public class OutputView {

	private static final int DEFAULT_COUNT = 0;
	private static final int MIN_WIN_COUNT = 3;
	private static final int MAX_WIN_COUNT = 6;
	private static final int BENEFIT_STANDARD = 1;

	public void resultView(HashMap<Integer, Integer> totalCount, int bonusMatchCount) {
		System.out.println("당첨 통계");
		System.out.println("--------");

		for (int key = MIN_WIN_COUNT; key <= MAX_WIN_COUNT; key++) {
			showResult(key, bonusMatchCount, totalCount);
		}
	}

	private void showResult(int key, int bonusMatchCount, HashMap<Integer, Integer> totalCount) {
		int countOfMatch = Rank.of(key).getCountOfMatch();

		if (countOfMatch == SECOND.getCountOfMatch()) {
			rankSecondMessage(bonusMatchCount, countOfMatch);
			return;
		}

		System.out.printf("%s개 일치" + "(%d)- " + totalCount.get(key) + "개\n", countOfMatch,
			Rank.of(key).getWinningMoney());
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
		if (rate < BENEFIT_STANDARD) {
			return false;
		}
		return true;
	}

	private void defaultMessage(double rate) {
		System.out.println("수익률은 " + String.format("%.2f", rate) + "입니다");
	}

	private void rankSecondMessage(int countOfBonus, int countOfMatch) {
		System.out.printf(
			"%s개 일치" + "(%d)- " + (SECOND.getCountOfMatch() - countOfBonus) + "개\n",
			countOfMatch, THIRD.getWinningMoney());

		System.out.printf("%s개 일치,보너스 볼 일치" + "(%d)- " + countOfBonus + "개\n",
			countOfMatch, SECOND.getWinningMoney());
	}


}
