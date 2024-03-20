package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.HashMap;

public class ResultView {

	public static void printLottoCount(int count) {
		System.out.println(count + "개를 구매했습니다.");
	}

	public static void printLottos(Lottos lottos) {
		lottos.getLottos().forEach(lotto -> System.out.println(lotto.getLottoNumber().toString()));
	}

	public static void printWinningStatistics(HashMap<LottoRank, Integer> winningStatistics) {
		System.out.println(winningStatistics.values());
	}

}
