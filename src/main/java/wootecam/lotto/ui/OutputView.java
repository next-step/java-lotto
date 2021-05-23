package wootecam.lotto.ui;

import java.util.Arrays;
import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;

public class OutputView extends View {

	public static final String LOTTO_COUNT_OUTPUT_FORMAT = "%d개를 구매했습니다.%n";
	public static final String SCORE_FORMAT = "%d개 일치 (%d원) - %d%n";
	public static final String EARNING_RATE_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	public static final String EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";
	public static final String SCORE_BOARD_TITLE = "당첨 통계";
	public static final String LINE_TEXT = "--------";
	public static final String EXIT_LOTTO_MESSAGE = "구매한 로또가 없어 로또 게임을 종료합니다.";

	public void printLottoCount(LottoCount lottoCount) {
		out.printf(LOTTO_COUNT_OUTPUT_FORMAT, lottoCount.getCount());
	}

	public void printAutomaticLotto(List<Lotto> lottos) {
		lottos.stream()
			.map(lotto -> "[" + lotto.toLottoNumberString() + "]")
			.forEach(out::println);
	}

	public void printLottoScoreMap(LottoScoreMap lottoScoreMap) {
		out.println(SCORE_BOARD_TITLE);
		out.println(LINE_TEXT);

		Arrays.stream(LottoResult.values())
			.filter(lottoResult -> lottoResult != LottoResult.DEFEAT)
			.forEach(lottoResult -> {
				out.printf(SCORE_FORMAT,
					lottoResult.getMatchedCount(),
					lottoResult.getWinningMoney(),
					lottoScoreMap.getLottoScores().get(lottoResult));
			});
	}

	public void printEarningRate(LottoScoreMap lottoScoreMap) {
		double earningRate = lottoScoreMap.getEarningRate();
		out.printf(EARNING_RATE_FORMAT, earningRate);
		if (earningRate < 1) {
			out.print(EARNING_RATE_LOSS_MESSAGE);
		}
	}

	public void printExitLottoGame() {
		out.println(EXIT_LOTTO_MESSAGE);
	}
}
