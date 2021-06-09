package com.nextstep.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import com.nextstep.lotto.lotto.Lotto;
import com.nextstep.lotto.lotto.LottoNumber;
import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.result.LottoResult;
import com.nextstep.lotto.result.LottoRank;

public class LottoOutput {

	private static final String STRING_DELIMITER = ", ";
	private static final String MESSAGE_INPUT_BUY_LOTTO_MESSAGE = "구입금액을 입력해주세요.";
	private static final String MESSAGE_NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
	private static final String MESSAGE_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String MESSAGE_STATISTICS_HEAD_STRING = "당첨 통계";
	private static final String MESSAGE_NUMBER_MATCH_STRING = "%d개 일치 (%d원)- %d 개";
	private static final String MESSAGE_REVENUE_RATIO_STRING = "총 수익률은 %.2f 입니다.";

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
		Set<LottoNumber> numbers = lotto.numbers();
		List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
		Collections.sort(lottoNumbers);

		StringJoiner stringJoiner = new StringJoiner(STRING_DELIMITER);
		for (LottoNumber lottoNumber : lottoNumbers) {
			stringJoiner.add(String.valueOf(lottoNumber));
		}
		System.out.println("[" + stringJoiner + "]");
	}

	public void printStatistics(LottoResult lottoResult) {
		System.out.println();
		System.out.println(MESSAGE_STATISTICS_HEAD_STRING);

		StringBuilder stringBuilder = new StringBuilder();
		for (Integer matchCount : lottoResult.statistics().keySet()) {
			String format = String.format(MESSAGE_NUMBER_MATCH_STRING
				, matchCount
				, LottoRank.valueOf(matchCount, true).getReward()
				, lottoResult.statistics().get(matchCount)
			);

			stringBuilder.append(format);
			stringBuilder.append(System.lineSeparator());
		}

		System.out.println(stringBuilder);
	}

	public void printRevenueRatio(Double ratio) {
		System.out.println(String.format(MESSAGE_REVENUE_RATIO_STRING, ratio));
	}
}
