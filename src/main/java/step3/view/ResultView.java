package step3.view;

import step3.model.Lotto;
import step3.model.LottoResult;
import step3.model.Rank;

import java.util.List;

public class ResultView {
	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}

	public void printResult(LottoResult lottoResult) {
		System.out.println("\n당첨 통계\n---------");
		System.out.printf("3개 일치 (%d원)- %d개\n", Rank.FIFTH.getPrize(), lottoResult.getRankCount(Rank.FIFTH));
		System.out.printf("4개 일치 (%d원)- %d개\n", Rank.FOURTH.getPrize(), lottoResult.getRankCount(Rank.FOURTH));
		System.out.printf("5개 일치 (%d원)- %d개\n", Rank.THIRD.getPrize(), lottoResult.getRankCount(Rank.THIRD));
		System.out.printf("5개 일치, 보너스 볼 일치(%d원)- %d개\n", Rank.SECOND.getPrize(), lottoResult.getRankCount(Rank.SECOND));
		System.out.printf("6개 일치 (%d원)- %d개\n", Rank.FIRST.getPrize(), lottoResult.getRankCount(Rank.FIRST));
		System.out.printf("총 수익률은 %s입니다.\n", String.valueOf(lottoResult.getProfit()));
	}
}
