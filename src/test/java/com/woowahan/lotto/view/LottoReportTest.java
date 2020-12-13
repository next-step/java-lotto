package com.woowahan.lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.model.Lotto;
import com.woowahan.lotto.model.LottoNo;
import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.LottoResultType;
import com.woowahan.lotto.model.Lottos;
import com.woowahan.lotto.model.PurchaseInput;
import com.woowahan.lotto.model.WinNumbers;

class LottoReportTest {

	@DisplayName("reportLottos 메소드를 통해 10000원의 입력값을 전달해만든 Lottos객체를 전달하면 '수동으로 3장, 자동으로 7개를 구매했습니다.\n.' 메세지가 포함된다.")
	@Test
	void reportLottos() {
		PurchaseInput purchaseInput = PurchaseInput.of("10000", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45"));
		Lottos lottos = Lottos.purchase(PurchaseInput.of("10000", Arrays.asList("1,2,3,4,5,6", "40,41,42,43,44,45")));
		int manualCount = purchaseInput.getManualLottoCount();
		String result = LottoReport.reportLottos(lottos.getLottos(), manualCount);

		assertThat(result).contains(String.format(Message.MSG_PURCHASE_LOTTO_COUNT, manualCount, 10 - manualCount));
	}

	@DisplayName("reportLottoResult 당첨 통계 문자열을 얻을 수 있고, 3개 이상 매칭된 결과 리포트 값이 포함된다.")
	@ParameterizedTest
	@MethodSource("argReportLottoResult")
	void reportLottoResult(WinNumbers input) {
		List<Lotto> lottos = Arrays.asList(
			Lotto.of(Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6))),
			Lotto.of(Arrays.asList(LottoNo.of(11), LottoNo.of(12), LottoNo.of(13), LottoNo.of(14), LottoNo.of(15), LottoNo.of(16))),
			Lotto.of(Arrays.asList(LottoNo.of(21), LottoNo.of(22), LottoNo.of(23), LottoNo.of(24), LottoNo.of(25), LottoNo.of(26)))
		);
		LottoResult lottoResult = LottoResult.analyze(input, lottos);
		Map<LottoResultType, Integer> results = lottoResult.getResults();

		String result = LottoReport.reportLottoResult(lottoResult);

		for (LottoResultType resultType : LottoResultType.getReportTargets()) {
			assertThat(result).contains(combineMsg(results, resultType));
		}
	}

	private String combineMsg(Map<LottoResultType, Integer> results, LottoResultType resultType) {
		String msg = Message.MSG_WIN_STATISTICS;
		if (LottoResultType.FIVE_MATCH_AND_BONUS.equals(resultType)) {
			msg = Message.MSG_WIN_BONUS_STATISTICS;
		}
		return String.format(msg
			, resultType.getMatchCount()
			, resultType.getReward()
			, results.get(resultType));
	}

	public static Stream<Arguments> argReportLottoResult() {
		return Stream.of(
			Arguments.of(WinNumbers.of("1,2,3,43,44,45", "10")),
			Arguments.of(WinNumbers.of("1,2,11,12,13,14", "45")),
			Arguments.of(WinNumbers.of("21,22,23,24,25,31", "1")),
			Arguments.of(WinNumbers.of("1,2,3,4,5,6", "45"))
		);
	}
}