package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoReport;
import lotto.domain.LottoTicket;
import lotto.domain.UserLotto;

import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoRank.*;

public class LottoView {

	public static final String LINE_SEPARATOR = "\r\n";
	public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String LOTTO_TICKET_COUNT_FORMAT = "%d개를 구매했습니다.";
	public static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String EARNING_RESULT_MESSAGE_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
	public static final String STATISTIC_HEADER_MESSAGE =
			LINE_SEPARATOR + "당첨 통계" + LINE_SEPARATOR + "---------";
	public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

	private static final String MESSAGE_FORMAT = "%d개 일치 (%s원)- %d개";
	private static final String SECOND_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)- %d개";

	public String inputMoneyView() {
		return INPUT_MONEY_MESSAGE;
	}

	public String userLottoCountView(int count) {
		return String.format(LOTTO_TICKET_COUNT_FORMAT, count);
	}

	public String inputWinningLottoNumbers() {
		return INPUT_WINNING_LOTTO_NUMBERS_MESSAGE;
	}

	public String inputBonusNumber() {
		return INPUT_BONUS_NUMBER_MESSAGE;
	}

	public String userLottoNumberListView(UserLotto userLotto) {
		return userLotto.lottoTickets()
				.stream()
				.map(LottoTicket::toString)
				.collect(Collectors.joining(LINE_SEPARATOR));
	}

	public String lottoReportView(LottoReport lottoReport) {
		return STATISTIC_HEADER_MESSAGE + LINE_SEPARATOR
				+ buildLottoRankMessage(lottoReport.lottoRankMap()) + LINE_SEPARATOR
				+ String.format(EARNING_RESULT_MESSAGE_FORMAT, lottoReport.earningRatio(),
				lottoReport.earningResultMessage());
	}

	private String buildLottoRankMessage(Map<LottoRank, Integer> lottoRankMap) {
		return formatMessage(FIFTH, lottoRankMap.getOrDefault(FIFTH, 0)) + LINE_SEPARATOR
				+ formatMessage(FOURTH, lottoRankMap.getOrDefault(FOURTH, 0)) + LINE_SEPARATOR
				+ formatMessage(THIRD, lottoRankMap.getOrDefault(THIRD, 0)) + LINE_SEPARATOR
				+ formatMessage(SECOND, lottoRankMap.getOrDefault(SECOND, 0)) + LINE_SEPARATOR
				+ formatMessage(FIRST, lottoRankMap.getOrDefault(FIRST, 0));
	}

	private String formatMessage(LottoRank lottoRank, Integer lottoCount) {
		if (lottoRank.equals(SECOND)) {
			return String.format(SECOND_MESSAGE_FORMAT, lottoRank.matchCount(), lottoRank.money(), lottoCount);
		}

		return String.format(MESSAGE_FORMAT, lottoRank.matchCount(), lottoRank.money(), lottoCount);
	}

}
