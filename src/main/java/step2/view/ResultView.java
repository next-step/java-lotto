package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoWinning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

	public static void printLottos(List<Lotto> lottos) {
		System.out.println(lottos.size()+"개를 구매했습니다.");
		for (Lotto lotto : lottos) {
			System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
		}
		System.out.println();
	}

	public static void printWinningResult(Map<Integer, Integer> result) {
		System.out.println("당첨 통계");
		System.out.println("----------");

		for (Integer matching : result.keySet()) {
			System.out.println(matching + "개 일치 (" + LottoWinning.of(matching).getReward()+")-" + result.get(matching) + "개");
		}
	}

	public static void printYield(double yield) {
		System.out.println("총 수익률은 "+ String.format("%.2f", yield) + "입니다.");
	}

}
