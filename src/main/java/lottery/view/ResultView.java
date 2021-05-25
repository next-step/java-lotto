package lottery.view;

import lottery.Result;

public class ResultView {

	public void printResult(Result result, float yield) {
		System.out.println("당첨 통계");
		System.out.println("-----------");
		result.getResultMap()
			.forEach(
				(matchType, count) -> System.out.printf("%d개 일치 (%d원) - %d개\n", matchType.matchCount(), matchType.money().amount(), count)
		);
		System.out.printf("총 수익률은  %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", yield);
	}
}
