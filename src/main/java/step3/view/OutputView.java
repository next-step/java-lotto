package step3.view;

import step3.model.Awards;
import step3.model.Lotto;
import step3.model.LottoList;

import java.util.Map;

public class OutputView {

	private static final int RATE_MSG_CRITERION = 1;
	private static final int AWARD_START_NUMBER = 5;
	private static final int AWARD_END_NUMBER = 1;

	public void printTicketCnt(final int ticketCnt) {
		System.out.printf("%d개를 구매했습니다.\n", ticketCnt);
	}

	public void printLottoNumbers(final LottoList lottoList) {
		lottoList.getLottoList().stream()
				.map(Lotto::getNumberList)
				.forEach(System.out::println);
	}

	public void printHitStatistics(final Map<Integer, Integer> hitStatistics, final double earningRate) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (int i = AWARD_START_NUMBER; i >= AWARD_END_NUMBER; i --) {
			System.out.printf("%d개 일치", Awards.getHitCnt(i));
			printBonusMSG(i);
			System.out.printf("(%d원) - %d개\n", Awards.getAward(i), hitStatistics.get(i));
		}
		System.out.printf("총 수익률은 %.2f입니다.", Math.floor(earningRate * 100) / 100.0);
		if (earningRate < RATE_MSG_CRITERION) {
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}
	}

	private static void printBonusMSG(int i) {
		if (Awards.isBonus(i)) {
			System.out.print(", 보너스 볼 일치");
		}
	}
}
