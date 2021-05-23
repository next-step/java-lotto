package lotto;

import lotto.domain.LottoReport;

public class LottoView {

	public static final String LINE_SEPARATOR = "\r\n";
	public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String LOTTO_TICKET_COUNT_FORMAT = "%d개를 구매했습니다.";
	public static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String EARNING_RESULT_MESSAGE_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
	public static final String STATISTIC_HEADER_MESSAGE =
		LINE_SEPARATOR + "당첨 통계" + LINE_SEPARATOR + "---------" + LINE_SEPARATOR;

	public String inputMoneyView() {
		return INPUT_MONEY_MESSAGE;
	}

	public String userLottoCountView(int count) {
		return String.format(LOTTO_TICKET_COUNT_FORMAT, count);
	}

	public String inputWinningLottoNumbers() {
		return INPUT_WINNING_LOTTO_NUMBERS_MESSAGE;
	}

	public String lottoReportView(LottoReport lottoReport) {
		return lottoReport.lottoRankMessage() + LINE_SEPARATOR
			+ String.format(EARNING_RESULT_MESSAGE_FORMAT, lottoReport.earningRatio(),
			lottoReport.earningResultMessage());
	}

	public String userLottoNumberListView(String lottoNumberMessage) {
		return STATISTIC_HEADER_MESSAGE + lottoNumberMessage;
	}

}
