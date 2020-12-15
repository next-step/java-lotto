package lotto.view;

import lotto.domain.LottoMatchResults;
import lotto.domain.LottoNumbers;

public class ResultView {
	public static void printAutoLottoNumbers(int manualNumberSize, LottoNumbers lottoNumbers) {
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualNumberSize, lottoNumbers.getLottoNumbersSize());
		System.out.println(lottoNumbers.toString());
	}

	public static void printMatchResult(LottoMatchResults matchResults) {
		System.out.println("당첨 통계");
		System.out.println("------------");
		System.out.println(matchResults.toString());
	}

	public static void printEarningRate(double earningRate) {
		System.out.printf("총 수익률은 %.2f 입니다.", earningRate);

		if (isLoss(earningRate)) {
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임.)");
		}
	}

	private static boolean isLoss(double earningRate) {
		return earningRate < 1;
	}
}
