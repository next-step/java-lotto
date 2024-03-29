package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class PrintView {
	public static void printNumberOfLotto(int number) {
		System.out.println(number + "개를 구매했습니다.");
	}

	public static void printLottos(List<Lotto> lottos) {
		System.out.println(
				lottos.stream()
				.map(Lotto::getLottoNumbersString)
				.collect(Collectors.joining("\n"))
		);
	}

	public static void printLottoResult(LottoResult lottoResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		for(Prize prize : Prize.values()) {
			System.out.println(prize.getCount() + "개 일치 (" + prize.getPrice() + "원)- "
					+ lottoResult.getNumberOfMatchedLotto(prize.getCount()) + "개");
		}

		System.out.print("총 수익률은 " + lottoResult.getRate() + "입니다.");

		if(lottoResult.isLoss()) {
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}
	}
}
