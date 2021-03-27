package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;

public class ResultView {
	public void printLottoGameList(List<Lotto> lottoList) {
		System.out.println(lottoList.size() + "개를 구매했습니다.");
		lottoList.forEach((lottoGame) -> {
			System.out.println(Arrays.toString(lottoGame.getGameNumberList().toArray()));
		});
		System.out.println();
	}

	public void printStatus(RankingResult rankingResult, double ror) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("------------");
		for (Ranking ranking : Ranking.values()) {
			System.out.println(
				ranking.getMatchCount() + "개 일치 (" + ranking.getPrice() + "원) - " + rankingResult.getResult()
					.get(ranking) + "개");
		}
		System.out.println("총 수익률은 " + ror + "입니다.");
	}
}
