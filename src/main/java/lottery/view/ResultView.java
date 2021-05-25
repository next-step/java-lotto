package lottery.view;

import java.util.Arrays;
import java.util.Map;

import lottery.LotteryMatchType;
import lottery.Result;

public class ResultView {

	public void printResult(Result result, float yield) {

		print("당첨 통계");
		print("-----------");
		final Map<LotteryMatchType, Integer> resultMap = result.getResultMap();
		Arrays.stream(LotteryMatchType.values())
			.filter(matchType -> matchType != LotteryMatchType.MISS_MATCH)
			.forEachOrdered(
				matchType -> {
					if (resultMap.containsKey(matchType)) {
						makeMatchStringTemplate(matchType, resultMap.get(matchType));
					}
					makeMatchStringTemplate(matchType, 0);
				}
			);
		System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", yield);
	}

	private void makeMatchStringTemplate(LotteryMatchType matchType, Integer count) {
		StringBuilder sb = new StringBuilder();
		StringBuilder append = sb.append(matchType.matchCount())
			.append("개 일치");
		if (matchType == LotteryMatchType.FIVE_MATCH_WITH_BONUS) {
			append.append(", 보너스 볼 일치");
		}
		append.append(" (")
			.append(matchType.money().amount())
			.append("원)- " + count + "개");
		System.out.println(append);
	}

	private void print(String 당첨_통계) {
		System.out.println(당첨_통계);
	}
}
