package com.woowahan.lotto.view;

import java.util.List;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.model.Lotto;
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
}
