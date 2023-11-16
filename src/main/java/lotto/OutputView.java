package lotto;

import java.util.Map;

public class OutputView {
	public static void printResultPhrase() {
		System.out.println("당첨 통계");
		System.out.println("---------------");
	}

	public static void printResult(LottoResult lottoResult) {
		Map<LottoMatch, Integer> lottoMatchMap = lottoResult.lottoMatchMap();
		LottoMatch lottoMatch = null;
		int count = 0;
		for (Map.Entry<LottoMatch, Integer> entry : lottoMatchMap.entrySet()) {
			lottoMatch = entry.getKey();
			count = entry.getValue();
			System.out.printf("%d개 일치 (%d원) - %d개\n",
					lottoMatch.matchCount(), lottoMatch.amount(), count);
		}

		System.out.printf("총 수익률은 %.1f%s 입니다.", lottoResult.rateOfReturn(), "%");
	}
}
