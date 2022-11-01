package step2.view;

import static step2.model.Rank.MISS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import step2.model.Lotteries;
import step2.model.Rank;

public class OutputView {

	private static final int DEFAULT_COUNT = 0;
	private static final int BENEFIT_STANDARD = 1;

	public void resultView(HashMap<Rank, Integer> totalCount) {
		System.out.println("당첨 통계");
		System.out.println("--------");
		showResult(totalCount);

	}


	private void showResult(HashMap<Rank, Integer> totalCount) {
		Arrays.stream(Rank.values())
			.sorted(Comparator.reverseOrder())
			.filter(rank -> rank != MISS)
			.forEach(rank ->
				System.out.printf("%d개 일치 (%d원)- %d\n", rank.getCountOfMatch()
					, rank.getWinningMoney()
					, totalCount.get(rank)));
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


}
