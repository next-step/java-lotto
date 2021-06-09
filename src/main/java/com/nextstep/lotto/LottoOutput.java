package com.nextstep.lotto;

import com.nextstep.lotto.lotto.Lotto;
import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.result.LottoRank;
import com.nextstep.lotto.result.LottoResult;

public class LottoOutput {

	private static final String MESSAGE_INPUT_BUY_LOTTO_MESSAGE = "구입금액을 입력해주세요.";
	private static final String MESSAGE_NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
	private static final String MESSAGE_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String MESSAGE_STATISTICS_HEAD_STRING = "당첨 통계";
	private static final String MESSAGE_NUMBER_MATCH_STRING = "%d개 일치 (%d원)- %d 개";
	private static final String MESSAGE_NUMBER_MATCH_SECOND_STRING = "%d개 일치, 보너스 볼 일치(%d원)- %d 개";
	private static final String MESSAGE_REVENUE_RATIO_STRING = "총 수익률은 %.2f 입니다.";
	public static final String MESSAGE_INPUT_BONUS_BALL = "보너스볼을 입력해주세요.";

	public void printMoneyForLotto() {
		System.out.println(MESSAGE_INPUT_BUY_LOTTO_MESSAGE);
	}

	public void printLottoCount(int count) {
		System.out.println(String.format(MESSAGE_NUMBER_OF_LOTTO, count));
	}

	public void printWinningNumber() {
		System.out.println();
		System.out.println(MESSAGE_INPUT_WINNING_NUMBER);
	}

	public void printLottos(Lottos lottos) {
		System.out.println();
		for (Lotto lotto : lottos.userLottos()) {
			printLotto(lotto);
		}
	}

	private void printLotto(Lotto lotto) {
		System.out.println(lotto);
	}

	public void printStatistics(LottoResult lottoResult) {
		System.out.println();
		System.out.println(MESSAGE_STATISTICS_HEAD_STRING);

		StringBuilder stringBuilder = new StringBuilder();
		for (LottoRank rank : lottoResult.statistics().keySet()) {
			String format = getFormatString(lottoResult, rank);
			stringBuilder.append(format);
			stringBuilder.append(System.lineSeparator());
		}

		System.out.println(stringBuilder);
	}

	public void printRevenueRatio(Double ratio) {
		System.out.println(String.format(MESSAGE_REVENUE_RATIO_STRING, ratio));
	}

	public void printBonusNumber() {
		System.out.println(MESSAGE_INPUT_BONUS_BALL);
	}

	private String getFormatString(LottoResult lottoResult, LottoRank rank) {
		if (rank == LottoRank.SECOND_RANK) {
			return String.format(MESSAGE_NUMBER_MATCH_SECOND_STRING
				, rank.getMatchCount()
				, LottoRank.valueOf(rank.getMatchCount(), true).getReward()
				, lottoResult.statistics().get(rank)
			);
		}
		return String.format(MESSAGE_NUMBER_MATCH_STRING
			, rank.getMatchCount()
			, LottoRank.valueOf(rank.getMatchCount(), false).getReward()
			, lottoResult.statistics().get(rank)
		);
	}
}
