package step2.view;

import java.util.List;
import java.util.stream.Collectors;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoStatistics;
import step2.domain.Money;
import step2.domain.var.LottoPrize;

public class ResultView {
	public static void printLottoResult(List<Lotto> result) {
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append(" 개를 구매했습니다.\n");
		printLottos(result, sb);
		System.out.println(sb);
	}

	private static void printLottos(List<Lotto> result, StringBuilder sb) {
		result.forEach((lotto) -> {
			List<Integer> numbers = lotto.getLottoNumbers()
				.stream()
				.map(LottoNumber::getNumber)
				.collect(Collectors.toList());
			sb.append("[");
			for (int i = 0; i < numbers.size(); i++) {
				sb.append(numbers.get(i));
				if (i < numbers.size() - 1) {
					sb.append(", ");
				}
			}
			sb.append("]\n");
		});
	}

	public static void printLottoStast(LottoStatistics stastResult) {
		StringBuilder sb = new StringBuilder();
		sb.append("당첨 통계").append("\n");
		sb.append("---------").append("\n");
		for (LottoPrize prize : LottoPrize.values()) {
			if (!prize.equals(LottoPrize.MISS)) {
				sb.append(prize.getCount());
				if (prize.equals(LottoPrize.SECOND)) {
					sb.append("개 일치, 보너스 볼 일치 (");
				} else {
					sb.append("개 일치 (");
				}
				sb.append(prize.getPrize())
					.append("원) - ")
					.append(stastResult.getWinnerCount(prize))
					.append("개\n");
			}
		}
		sb.append("총 수익률은 ").append(stastResult.getProfitRatio()).append("% 입니다.\n");
		System.out.println(sb);
	}

	public static void printChange(Money change) {
		System.out.println("로또를 사고 남은 거스름돈 " + change.getMoney() + "원을 받았습니다.");
	}
}
