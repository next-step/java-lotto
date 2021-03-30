package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;

public class ResultView {
	public void printLottoGameList(List<Lotto> lottoList, int purchasePrice, int size) {
		int autoPurchaseNumbers = (purchasePrice - (size * Lotteries.PRICE_PER_GAME)) / Lotteries.PRICE_PER_GAME;
		System.out.println("수동으로" + size + "장, 자동으로 " + autoPurchaseNumbers + "개를 구매했습니다.");
		lottoList.forEach((lottoGame) -> {
			System.out.println(Arrays.toString(lottoGame.getGameNumberList().toArray()));
		});
		System.out.println();
	}

	public void printStatus(RankingResult rankingResult, double ror) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("------------");
		Ranking[] rankings = Ranking.values();
		for (int i = 0; i < rankings.length; i++) {
			printLine(rankingResult, rankings[i]);
		}
		System.out.println("총 수익률은 " + ror + "입니다.");
	}

	private void printLine(RankingResult rankingResult, Ranking ranking) {
		String matchCount =
			(ranking.equals(Ranking.SECOND)) ? ranking.getMatchCount() + "개 일치, 보너스 볼 일치" :
				ranking.getMatchCount() + "개 일치";
		System.out.println(
			matchCount + " (" + ranking.getPrice() + "원) - " + rankingResult.getResult()
				.get(ranking) + "개");
	}
}
