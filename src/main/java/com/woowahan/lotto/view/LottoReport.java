package com.woowahan.lotto.view;

import java.util.List;
import java.util.Map;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.model.EarnType;
import com.woowahan.lotto.model.Lotto;
import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.LottoResultType;
import com.woowahan.lotto.model.Lottos;

public class LottoReport {

	public static String reportLottos(Lottos lottos) {
		List<Lotto> allLottos = lottos.getLottos();
		StringBuilder result = new StringBuilder(String.format(Message.MSG_PURCHASE_LOTTO_CNT, allLottos.size()));
		for (Lotto lotto : allLottos) {
			result.append(lotto.getNumbers())
				.append(Message.MSG_LINE_BREAK);
		}
		result.append(Message.MSG_LINE_BREAK);
		return result.toString();
	}

	public static String reportLottoResult(LottoResult result) {
		String report = Message.MSG_WIN_STATISTICS_TITLE;
		for (LottoResultType resultType : LottoResultType.getReportTargets()) {
			report += getResultByResultType(result.getResults(), resultType);
		}

		report += getResultByEarnRate(result);
		return report;
	}

	private static String getResultByResultType(Map<LottoResultType, Integer> results, LottoResultType resultType) {
		String msg = Message.MSG_WIN_STATISTICS;
		if (LottoResultType.FIVE_MATCH_AND_BONUS.equals(resultType)) {
			msg = Message.MSG_WIN_BONUS_STATISTICS;
		}
		return String.format(msg
			, resultType.getMatchCount()
			, resultType.getReward()
			, results.get(resultType));
	}

	private static String getResultByEarnRate(LottoResult result) {
		double earnRate = result.getEarnRate();
		EarnType earnType = EarnType.judge(earnRate);
		return String.format(Message.MSG_EARN_RATE
			, earnRate, earnType.getMsg());
	}
}
