package step2.view;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.domain.var.LottoPrize;

public class ResultView {
	public static void printLottoResult(List<Lotto> result) {
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append(" 개를 구매했습니다.\n");
		for (Lotto lotto : result) {
			sb.append(lotto.toString()).append("\n");
		}
		System.out.println(sb);
	}

	public static void printLottoStast(LottoStast stastResult) {
		StringBuilder sb = new StringBuilder();
		sb.append("당첨 통계").append("\n");
		sb.append("---------").append("\n");
		for (LottoPrize prize : LottoPrize.values()) {
			sb.append(prize.getCount())
				.append("개 일치 (")
				.append(prize.getPrize())
				.append("원) - ")
				.append(stastResult.getWinnerCount(prize))
				.append("개\n");
		}
		sb.append("총 수익률은 ").append(stastResult.getProfitRatio()).append("% 입니다.\n");
		System.out.println(sb);
	}

	public static void printChange(Money change) {
		System.out.println("로또를 사고 남은 거스름돈 " + change.getMoney() + "원을 받았습니다.");
	}
}
