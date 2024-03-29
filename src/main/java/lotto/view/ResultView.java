package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.Map;

public class ResultView {

	public static void printLottoCount(int manualLottoCount, int autoLottoCount) {
		System.out.println("수동으로 " + manualLottoCount + "장," + "자동으로 " + autoLottoCount + "개를 구매했습니다.");
	}

	public static void printLottos(Lottos lottos) {
		lottos.getLottos().forEach(lotto -> System.out.println(lotto.getLottoNumbers().toString()));
	}

	public static void printWinningStatistics(Map<LottoRank, Integer> winningStatistics) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		checkWinningStatistics(winningStatistics);

		winningStatistics.entrySet().forEach(entry -> {
			String prefix = (entry.getKey() == LottoRank.SECOND) ? "개 일치 보너스 볼 일치" : "개 일치";
			System.out.println(entry.getKey().getLottoCount() + prefix + " (" + entry.getKey().getWinningMoney() + "원)- " + entry.getValue() + "개");
		});
	}

	private static void checkWinningStatistics(Map<LottoRank, Integer> winningStatistics) {
		if (winningStatistics.isEmpty()) {
			System.out.println("로또번호와 일치하는 게 없습니다");
		}
	}

	public static void printRateOfReturn(double winningRate) {
		System.out.println("총 수익률은 " + winningRate + "입니다.");
	}

}
