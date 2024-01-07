package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.LottoResult;

public final class ResultView {
	public static void printEntireLotto(final Lottos entireLotto) {
		for (Lotto lotto : entireLotto.lottos()) {
			System.out.print("[");
			System.out.print(String.join(", ", integers(lotto)));
			System.out.println("]");
		}
	}

	private static List<String> integers(final Lotto lotto) {
		List<String> result = new ArrayList<>();

		for (LottoNumber lottoNumber : lotto.lotto()) {
			result.add(lottoNumber.toString());
		}

		return result;
	}

	public static void printStatistics(final LottoResult lottoResult, final Money money) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println("3개 일치 (5000원)- " + lottoResult.rankCount(Rank.RANK5) + "개");
		System.out.println("4개 일치 (50000원)- " + lottoResult.rankCount(Rank.RANK4) + "개");
		System.out.println("5개 일치 (1500000원)- " + lottoResult.rankCount(Rank.RANK3) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + lottoResult.rankCount(Rank.RANK2) + "개");
		System.out.println("6개 일치 (2000000000원)- " + lottoResult.rankCount(Rank.RANK1) + "개");
		System.out.printf("총 수익률은 %.2f입니다.", money.calculateRate(lottoResult));
	}
}
