package lotto.view;

import lotto.domain.LottoMatchResults;
import lotto.domain.LottoNumbers;

public class ResultView {
	public static void printLottoNumbers(LottoNumbers lottoNumbers) {
		System.out.println(lottoNumbers.getLottoNumbersSize() + "개를 구매했습니다.");
		System.out.println(lottoNumbers.toString());
	}

	public static void printMatchResult(LottoMatchResults matchResults) {
		System.out.println("당첨 통계");
		System.out.println("------------");
		System.out.println(matchResults.toString());
		System.out.print("총 수익률은 " + String.format("%.2f", matchResults.getEarningRate()) + "입니다.");

		if (matchResults.isLoss()) {
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임.)");
		}
	}
}
