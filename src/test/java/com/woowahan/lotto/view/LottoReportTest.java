package com.woowahan.lotto.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.model.Lottos;
import com.woowahan.lotto.model.PurchaseInput;

class LottoReportTest {

	@DisplayName("reportLottos 메소드를 통해 10000원의 입력값을 전달해만든 Lottos객체를 전달하면 '10개를 구매했습니다.' 메세지가 포함된다.")
	@Test
	void reportLottos() {
		Lottos lottos = Lottos.purchase(PurchaseInput.of("10000"));
		String result = LottoReport.reportLottos(lottos);

		assertThat(result).contains(String.format(Message.MSG_PURCHASE_LOTTO_CNT, 10));
	}
}