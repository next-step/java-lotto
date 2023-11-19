package lotto.view;

import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {

	public void printLotto(List<Integer>[] lotto) {
		System.out.println(lotto.length + "개를 구매했습니다.");
		for (List<Integer> numbers : lotto) {
			System.out.println(numbers.toString());
		}
		System.out.println();
	}

	public void printStatistics(Map<LottoRank, Integer> lottoRankMap, double returnRate) {
		System.out.println();
		System.out.println("당첨통계");
		System.out.println("---------");
		for (LottoRank lottoRank : LottoRank.values()) {
			if (lottoRank.equals(LottoRank.BLANK)) continue;
			Integer t = lottoRankMap.get(lottoRank);
			if (t == null) t = 0;
			System.out.println(lottoRank.rank() + "개 일치 (" + lottoRank.money() + ") - " + t + "개");
		}
		System.out.println("총 수익률은 " + returnRate + "입니다.");
	}
}
