package step2.view;

import java.util.List;

public class ResultView {
	public void showLottos(List<List<Integer>> lottos) {
		System.out.println(lottos.size() + "개를 구매했습니다.");
		lottos.forEach(lotto -> System.out.println(lotto));
	}
/*
	public void showStatistic(int[] statistic) {
		long sum = 0;
		for (int i = 3; i < statistic.length; i++) {
			System.out.printf("%d개 일치 : (%d원)- %d개\n", i, statistic[i], AutoLotto.PRICES[i]);
			if (statistic[i] > 0) sum += AutoLotto.PRICES[i];
		}
		System.out.println("총 수익은 " + sum + "입니다.");
	}
	*/
}
