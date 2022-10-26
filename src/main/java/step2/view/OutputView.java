package step2.view;

import step2.model.lotto.Lottos;
import step2.model.lotto.WinningAmount;

public class OutputView {

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	public void printLottos(Lottos lottos) {
		lottos.forEach(
			lotto -> System.out.println(lotto.getNumbers().toString())
		);
	}

	public void printWinningStatisticsHeader() {
		System.out.println("당첨 통계");
		System.out.println("---------");
	}

	public void printWinningStatistics(WinningAmount winningAmount, int count) {
		System.out.printf("%d 개 일치 (%d원)- %d개 \n", winningAmount.getMatchCount(), winningAmount.getPrize(), count);
	}

	public void printYield(double prize, double amount) {
		System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", Math.floor(prize / amount * 100) / 100);
	}
}
