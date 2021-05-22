package lotto.ui;

import lotto.Lottos;
import lotto.Prize;

public class ResultView {

	public void output(Lottos lottos) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.printf("%d개 일치 (%d원) - %d개%n", Prize.SIX.count(), Prize.SIX.winAmount().money(),
			lottos.status(Prize.SIX));
		System.out.printf("%d개 일치 (%d원) - %d개%n", Prize.FIVE.count(), Prize.FIVE.winAmount().money(),
			lottos.status(Prize.FIVE));
		System.out.printf("%d개 일치 (%d원) - %d개%n", Prize.FOUR.count(), Prize.FOUR.winAmount().money(),
			lottos.status(Prize.FOUR));
		System.out.printf("%d개 일치 (%d원) - %d개%n", Prize.THREE.count(), Prize.THREE.winAmount().money(),
			lottos.status(Prize.THREE));

		System.out.printf("총 수익률은 %.2f 입니다.%n", lottos.profit().rate());
	}
}
