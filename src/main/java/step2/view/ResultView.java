package step2.view;

import step2.LottoGame;
import step2.model.AutoLotto;
import step2.model.Rank;

import java.util.List;

public class ResultView {
	private LottoGame lottoGame;

	public ResultView(LottoGame lottoGame) {
		this.lottoGame = lottoGame;
		List<AutoLotto> lottos = lottoGame.getLottos();
		System.out.println(lottos.size() + "개를 구매했습니다.");
		lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

	public void showStatistic(String winNumbers, int money) {
		long sum = 0;

		List<AutoLotto> lottos = lottoGame.getLottos();
		Rank rank;
		int[] rankCounts = new int[Rank.FIRST.getMatchCount() + 1];
		for (AutoLotto lotto : lottos) {
			rank = lotto.getRank(winNumbers);
			rankCounts[rank.getMatchCount()]++;
			sum += rank.getPrize();
		}

		for (int i = 0, iLen = rankCounts.length; i < iLen; i++) {
			rank = Rank.valueOf(i);
			if (rank == Rank.LOSE) continue;
			System.out.printf("%d개 일치 : (%d원)- %d개\n", i, rank.getPrize(), rankCounts[i]);
		}

		System.out.println("총 수익률은 " + (Math.floor((double) sum / money * 100) / 100.0) + "입니다.");
	}
}
