package step2.view;

import static step2.model.Rank.MISS;
import static step2.model.Rank.SECOND;

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
			.forEach(rank -> printMessage(rank, totalCount));
	}

	private void printMessage(Rank rank, HashMap<Rank, Integer> totalCount) {
		if (rank.equals(SECOND)) {
			System.out.printf("%d개 일치 보너스 볼 일치(%d원)- %d개\n"
				, rank.getCountOfMatch()
				, rank.getWinningMoney()
				, totalCount.get(rank));
			return;
		}

		System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getCountOfMatch()
			, rank.getWinningMoney()
			, totalCount.get(rank));
	}

	public void showTotalTicket(int handTicket, int autoTicket) {
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다\n", handTicket, autoTicket);
	}

	public void showLotteries(int tickets, Lotteries lotteries) {
		for (int i = DEFAULT_COUNT; i < tickets; i++) {
			System.out.println(lotteries
				.showLotteries(i)
				.getLotto()
				.getLottoNumbers());
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
