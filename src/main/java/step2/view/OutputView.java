package step2.view;

import step2.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

	public void printTicketCnt(final int ticketCnt) {
		System.out.printf("%d개를 구매했습니다.\n", ticketCnt);
	}

	public void printLottoNumbers(final List<Lotto> lottos) {
		lottos.stream()
				.map(Lotto::getLottoNumbers)
				.forEach(System.out::println);
	}

	public void pritnHitStatistics(Map<Integer, Integer> hitStatistics, double earningRate) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.printf("3개 일치 (5000원)- %d개\n", hitStatistics.getOrDefault(3, 0));
		System.out.printf("4개 일치 (50000원)- %d개\n", hitStatistics.getOrDefault(4, 0));
		System.out.printf("5개 일치 (1500000원)- %d개\n", hitStatistics.getOrDefault(5, 0));
		System.out.printf("6개 일치 (2000000000원)- %d개", hitStatistics.getOrDefault(6, 0));
		System.out.printf("총 수익률은 %s입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)", earningRate);
	}
}
