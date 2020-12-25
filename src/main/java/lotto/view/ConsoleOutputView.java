package lotto.view;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;

public class ConsoleOutputView {

	public static void showLottos(Lottos lottos) {
		System.out.println(lottos.size() + "개를 구매하였습니다.");
		IntStream.range(0, lottos.size()).forEach(index -> {
			Lotto lotto = lottos.get(index);
			showLotto(lotto);
		});
	}

	private static void showLotto(Lotto lotto) {
		String numbersString = IntStream.range(0, lotto.size())
			.mapToObj(lotto::getNumber)
			.map(String::valueOf)
			.collect(Collectors.joining(", "));
		System.out.println("[" + numbersString + "]");
	}

	public static void showLottoResults(LottoResults lottoResults, int money) {
		System.out.println("당첨 통계");
		System.out.println("--------");
		showWonLottos(lottoResults);
		showReturnRate(lottoResults, money);
	}

	private static void showWonLottos(LottoResults lottoResults) {
		System.out.println("3개 일치 (5,000원) - " + lottoResults.count(LottoResult.FOURTH));
		System.out.println("4개 일치 (50,000원) - " + lottoResults.count(LottoResult.THIRD));
		System.out.println("5개 일치 (1,500,000원) - " + lottoResults.count(LottoResult.SECOND));
		System.out.println("6개 일치 (2,000,000,000원) - " + lottoResults.count(LottoResult.FIRST));
	}

	private static void showReturnRate(LottoResults lottoResults, int money) {
		double returnRate = lottoResults.calculateReturnRate(money);
		System.out.println("총 수익률은 " + returnRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
	}
}
