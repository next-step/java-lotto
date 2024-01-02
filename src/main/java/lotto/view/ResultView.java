package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Ticket;

public final class ResultView {
	public static void printLottoNumber(final Ticket ticket) {
		for (Lotto lotto : ticket.ticket()) {
			System.out.print("[");
			System.out.print(String.join(", ", integers(lotto)));
			System.out.println("]");
		}
	}

	private static List<String> integers(Lotto lotto) {
		List<String> result = new ArrayList<>();

		for (LottoNumber lottoNumber : lotto.lotto()) {
			result.add(lottoNumber.toString());
		}

		return result;
	}

	public static void printStatistics(final List<Integer> statistics, final float rate) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.printf("3개 일치 (5000원)- %d개\n", statistics.get(5));
		System.out.printf("4개 일치 (50000원)- %d개\n", statistics.get(4));
		System.out.printf("5개 일치 (1500000원)- %d개\n", statistics.get(3));
		System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", statistics.get(2));
		System.out.printf("6개 일치 (2000000000원)- %d개\n", statistics.get(1));
		System.out.printf("총 수익률은 %.2f입니다.", rate);
	}
}
