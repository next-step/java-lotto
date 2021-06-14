package com.nextstep.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import com.nextstep.lotto.lotto.Lotto;
import com.nextstep.lotto.lotto.LottoNumber;
import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.result.LottoRank;
import com.nextstep.lotto.result.LottoResult;
import com.nextstep.lotto.store.LottoStore;

public class LottoOutput {

	public static final String DELIMITER = ", ";
	private static final String MESSAGE_INPUT_BUY_LOTTO_MESSAGE = "구입금액을 입력해주세요.";
	private static final String MESSAGE_NUMBER_OF_LOTTO = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
	private static final String MESSAGE_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String MESSAGE_STATISTICS_HEAD_STRING = "당첨 통계";
	private static final String MESSAGE_NUMBER_MATCH_STRING = "%d개 일치 (%d원)- %d 개";
	private static final String MESSAGE_NUMBER_MATCH_SECOND_STRING = "%d개 일치, 보너스 볼 일치(%d원)- %d 개";
	private static final String MESSAGE_REVENUE_RATIO_STRING = "총 수익률은 %.2f 입니다.";
	private static final String MESSAGE_INPUT_BONUS_BALL = "보너스볼을 입력해주세요.";
	public static final String MESSAGE_INPUT_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String MESSAGE_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

	public void printMoneyForLotto() {
		System.out.println(MESSAGE_INPUT_BUY_LOTTO_MESSAGE);
	}

	public void printManualLottoCount() {
		System.out.println(MESSAGE_INPUT_COUNT_OF_MANUAL_LOTTO);
	}

	public void printLottoCount(LottoStore lottoStore) {
		System.out.println();
		System.out.println(
			String.format(MESSAGE_NUMBER_OF_LOTTO, lottoStore.manualLottoCount(), lottoStore.autoLottoCount()));
	}

	public void printManualLottoInput(int manualLottoCount) {
		if (manualLottoCount > 0) {
			System.out.println(MESSAGE_INPUT_MANUAL_LOTTO_NUMBERS);
		}
	}

	public void printWinningNumber() {
		System.out.println();
		System.out.println(MESSAGE_INPUT_WINNING_NUMBER);
	}

	public void printLottos(Lottos lottos) {
		for (Lotto lotto : lottos.userLottos()) {
			printLotto(lotto);
		}
	}

	private void printLotto(Lotto lotto) {
		StringJoiner stringJoiner = new StringJoiner(DELIMITER);
		List<LottoNumber> lottoNumbers = lotto.numbers();
		Collections.sort(lottoNumbers);

		for (LottoNumber lottoNumber : lottoNumbers) {
			stringJoiner.add(String.valueOf(lottoNumber));
		}

		System.out.println("[ " + stringJoiner + " ]");
	}

	public void printStatistics(LottoResult lottoResult) {
		System.out.println();
		System.out.println(MESSAGE_STATISTICS_HEAD_STRING);

		Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.getMatchCount() > 0)
			.forEach(lottoRank -> System.out.println(getFormatString(lottoResult, lottoRank)));
	}

	public void printRevenueRatio(Double ratio) {
		System.out.println(String.format(MESSAGE_REVENUE_RATIO_STRING, ratio));
	}

	public void printBonusNumber() {
		System.out.println(MESSAGE_INPUT_BONUS_BALL);
	}

	private String getFormatString(LottoResult lottoResult, LottoRank rank) {
		String format = MESSAGE_NUMBER_MATCH_STRING;
		if (rank == LottoRank.SECOND_RANK) {
			format = MESSAGE_NUMBER_MATCH_SECOND_STRING;
		}

		return String.format(format
			, rank.getMatchCount()
			, LottoRank.valueOf(rank.getMatchCount(), false).getReward()
			, Optional.ofNullable(lottoResult.statistics().get(rank)).orElse(0L)
		);
	}
}
