package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

	public static void printLottos(List<Integer[]> lottos) {
		System.out.println(lottos.size()+"개를 구매했습니다.");
		for (Integer[] lotto : lottos) {
			System.out.println(Arrays.toString(lotto));
		}
		System.out.println();
	}

	public static void printWinningResult(Map<Integer, Integer> result) {
		System.out.println("당첨 통계");
		System.out.println("----------");

		LottoWinning[] winnings = LottoWinning.values();
		for (LottoWinning winning : winnings) {
			System.out.println(winning.getMatchingCount() + "개 일치 ("+winning.getReward()+")- " + result.get(winning.getMatchingCount()) + "개");
		}
	}

	public static void printYield(int price, int rewardsSum) {
		System.out.println("총 수익률은 "+ String.format("%.2f", (double)(rewardsSum / price)) + "입니다.");
	}

}
