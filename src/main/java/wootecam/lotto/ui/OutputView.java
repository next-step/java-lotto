package wootecam.lotto.ui;

import java.util.Arrays;
import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;

public class OutputView extends View {

	public static final String LOTTO_COUNT_OUTPUT_FORMAT = "%d개를 구매했습니다.";

	public void printLottoCount(LottoCount lottoCount) {
		out.println(String.format(LOTTO_COUNT_OUTPUT_FORMAT, lottoCount.getCount()));
	}

	public void printAutomaticLotto(List<Lotto> lottos) {
		lottos.stream()
			.map(lotto -> "[" + lotto.toLottoNumberString() + "]")
			.forEach(out::println);
	}

	public void printLottoScoreMap(LottoScoreMap lottoScoreMap) {
		out.println("당첨 통계");
		out.println("--------");

		Arrays.stream(LottoResult.values())
			.filter(lottoResult -> lottoResult != LottoResult.DEFEAT)
			.forEach(lottoResult -> {
				out.printf("%d개 일치 (%d원) - %d%n",
					lottoResult.getMatchedCount(),
					lottoResult.getWinningMoney(),
					lottoScoreMap.getLottoScores().get(lottoResult));
			});
	}
}
