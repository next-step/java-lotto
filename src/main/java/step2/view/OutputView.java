package step2.view;

import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.Rank;

public class OutputView {

	private static final int DEFAULT_COUNT = 0;
	private static final int MIN_WIN_COUNT = 3;
	private static final int MAX_WIN_COUNT = 6;
	private static final int BENEFIT_STANDARD = 1;

	public void resultView(HashMap<Integer, Integer> totalCount) {
		System.out.println("당첨 통계");
		System.out.println("--------");

		for (int key = MIN_WIN_COUNT; key <= MAX_WIN_COUNT; key++) {
			showResult(key, isValid(totalCount.get(key)));
		}
	}

	private int isValid(Integer matchSum) {
		if (matchSum == null) {
			return DEFAULT_COUNT;
		}
		return matchSum;
	}

	private void showResult(int key, int matchSum) {
		if (key >= MIN_WIN_COUNT && key <= MAX_WIN_COUNT) {
			System.out.printf("%s개 일치" + "(%d)- " + matchSum + "개\n",
				Rank.of(key).getCountOfMatch(), Rank.of(key).getWinningMoney());
		}
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


}
