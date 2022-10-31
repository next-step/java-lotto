package step2.view;

import step2.model.Awards;
import step2.model.Lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {

	public void printTicketCnt(final int ticketCnt) {
		System.out.printf("%d개를 구매했습니다.\n", ticketCnt);
	}

	public void printLottoNumbers(final List<Lotto> lottos) {
		lottos.stream()
				.map(Lotto::getLottoNumbers)
				.forEach(System.out::println);
	}

	public void pritnHitStatistics(final Map<Integer, Integer> hitStatistics, final double earningRate) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		IntStream.range(3, 7).forEachOrdered(hitCnt
				-> System.out.printf("%d개 일치 (%d원)- %d개\n",
				hitCnt, Awards.findAward(hitCnt).getAward(), hitStatistics.getOrDefault(hitCnt, 0)));
		System.out.printf("총 수익률은 %.2f입니다.", Math.floor(earningRate * 100) / 100.0);
		if(earningRate < 1){
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}
	}
}
