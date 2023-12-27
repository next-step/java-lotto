package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;

public final class ResultView {
	public static void printLottoNumber(final Ticket ticket) {
		for (Lottos lottos : ticket.ticket()) {
			System.out.print("[");
			System.out.print(String.join(", ", lottos.integers()));
			System.out.println("]");
		}
	}

	public static void printStatistics(final int[] statistics, final float rate) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.printf("3개 일치 (5000원)- %d개\n", statistics[0]);
		System.out.printf("4개 일치 (50000원)- %d개\n", statistics[1]);
		System.out.printf("5개 일치 (1500000원)- %d개\n", statistics[2]);
		System.out.printf("6개 일치 (2000000000원)- %d개\n", statistics[3]);
		System.out.printf("총 수익률은 %.2f입니다.", rate);
	}
}
