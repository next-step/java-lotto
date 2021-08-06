package lotto.view;

import lotto.domain.Lotto;
import lotto.enums.Rank;

public class ResultView {

	private ResultView() {

	}

	public static void outputNewLine() {
		System.out.println();
	}

	public static void outputLottoCount(int lottoCount) {
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	public static void outputLottoNumbers(Lotto lotto) {
		System.out.println("[" + lotto.toString() + "]");
	}

	public static void outputStatisticsTitle() {
		System.out.println("당첨 통계");
		System.out.println("---------");
	}

	public static void outputLottoNumbers(Rank rank, Integer count) {
		System.out.println(rank.getMatchNumberCount() + "개 일치 (" + rank.getReward() + ") - " + count + "개");
	}

	public static void outputYield(int money, long sumRevenue) {
		System.out.printf("총 수익률은 %.2f 입니다.\n", (double) sumRevenue / money);
	}
}
