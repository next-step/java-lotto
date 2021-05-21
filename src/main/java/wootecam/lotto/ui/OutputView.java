package wootecam.lotto.ui;

import wootecam.lotto.model.LottoCount;

public class OutputView extends View {

	public static final String LOTTO_COUNT_OUTPUT_FORMAT = "%d개를 구매했습니다.";

	public void printLottoCount(LottoCount lottoCount) {
		out.println(String.format(LOTTO_COUNT_OUTPUT_FORMAT, lottoCount.getCount()));
	}
}
