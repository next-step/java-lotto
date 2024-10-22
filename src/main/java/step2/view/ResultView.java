package step2.view;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoStast;
import step2.domain.var.LottoPrize;

public class ResultView {

	public static void printLottoResult(List<Lotto> result) {
		System.out.println(result.size() + " 개를 구매했습니다.");
		for (Lotto lotto : result) {
			System.out.println(lotto.toString());
		}
	}

	public static void printLottoStast(LottoStast stastResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(LottoPrize.FOURTH_WINNER.getCount() + "개 일치 (" +
			LottoPrize.FOURTH_WINNER.getPrize() + "원) - " + stastResult.getFourthWinnerCount() + "개");
		System.out.println(LottoPrize.THIRD_WINNER.getCount() + "개 일치 (" +
			LottoPrize.THIRD_WINNER.getPrize() + "원) - " + stastResult.getThirdWinnerCount() + "개");
		System.out.println(LottoPrize.SECOND_WINNER.getCount() + "개 일치 (" +
			LottoPrize.SECOND_WINNER.getPrize() + "원) - " + stastResult.getSecondWinnerCount() + "개");
		System.out.println(LottoPrize.FIRST_WINNER.getCount() + "개 일치 (" +
			LottoPrize.FIRST_WINNER.getPrize() + "원) - " + stastResult.getFirstWinnerCount() + "개");

		System.out.println("총 수익률은 " + stastResult.getProfitRatio() + "% 입니다.");
	}
}
