package step3.view;

import step3.model.Awards;
import step3.model.LottoList;

import java.util.Map;

public class OutputView {

	public void printTicketCnt(final int ticketCnt) {
		System.out.printf("%d개를 구매했습니다.\n", ticketCnt);
	}

	public void printLottoNumbers(final LottoList lottoList) {
		lottoList.getLottoList().stream()
				.map(lotto -> lotto.getNumberList())
				.forEach(System.out::println);
	}

	public void pritnHitStatistics(final Map<Integer, Integer> hitStatistics, final double earningRate) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (int i = 5; i > 0; i--) {
			System.out.printf("%d개 일치", Awards.getHitCnt(i));
			bonusWord(i);
			System.out.printf("(%d원) - %d개\n", Awards.getAward(i), hitStatistics.get(i));
		}
		System.out.printf("총 수익률은 %.2f입니다.", Math.floor(earningRate * 100) / 100.0);
		if(earningRate < 1){
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}
	}

	private static void bonusWord(int i) {
		if(i == 2){ System.out.printf(", 보너스 볼 일치");}
	}
}
