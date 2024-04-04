package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;

public class PrintView {
	static StringBuilder stringBuilder = new StringBuilder();

	public static void printAutoLottoGuide() {
		System.out.println("수동으로 구매할 번호를 입력해주세요.");
	}

	public static void printNumberOfLotto(int manualLotto, int autoLotto) {
		System.out.println("수동으로 "+ manualLotto +"장, 자동으로 " + autoLotto + "개를 구매했습니다.");
	}

	public static void printLottos(List<Lotto> lottos) {
		stringBuilder.setLength(0);

		for(Lotto lotto : lottos) {
			stringBuilder.append(lotto.getLottoNumbers()).append("\n");
		}

		System.out.println(stringBuilder);
	}

	public static void printLottoResult(LottoResult lottoResult) {
		stringBuilder.setLength(0);

		stringBuilder.append("당첨 통계\n");
		stringBuilder.append("---------\n");

		Arrays.stream(Prize.values())
				.filter(prize -> prize.getPrice() > 0)
				.forEach(prize -> {
					stringBuilder.append(prize.getCount()).append("개 일치");
					stringBuilder.append(prize == Prize.MATHCED_5_WITH_BONUS ? ", 보너스 볼 일치(" : " (");
					stringBuilder.append(prize.getPrice()).append("원)- ");
					stringBuilder.append(lottoResult.getNumberOfMatchedLotto(prize)).append("개\n");
				});

		stringBuilder.append("총 수익률은 ").append(lottoResult.getRate()).append("입니다.");

		if(lottoResult.isLoss()) {
			stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}

		System.out.println(stringBuilder);
	}
}
