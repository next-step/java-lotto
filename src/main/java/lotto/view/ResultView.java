package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.LottoGame;
import lotto.domain.Ranking;

public class ResultView {
	public void printLottoGameList(List<LottoGame> lottoGameList) {
		System.out.println(lottoGameList.size() + "개를 구매했습니다.");
		lottoGameList.forEach((lottoGame) -> {
			System.out.println(Arrays.toString(lottoGame.getGameNumberList().toArray()));
		});
		System.out.println();
	}

	public void printStatus(Map<Ranking, Integer> result, double ror) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("------------");
		for (Ranking ranking : Ranking.values()) {
			System.out.println(
				ranking.getMatchCount() + "개 일치 (" + ranking.getPrice() + "원) - " + result.get(ranking) + "개");
		}
		System.out.println("총 수익률은 " + ror + "입니다.");
	}
}
