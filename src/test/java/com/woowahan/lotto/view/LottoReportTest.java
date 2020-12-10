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
import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.LottoResultType;
import com.woowahan.lotto.model.Lottos;
import com.woowahan.lotto.model.PurchaseInput;
import com.woowahan.lotto.model.WinNumbers;

class LottoReportTest {

	@DisplayName("reportLottos 메소드를 통해 10000원의 입력값을 전달해만든 Lottos객체를 전달하면 '10개를 구매했습니다.' 메세지가 포함된다.")
	@Test
	void reportLottos() {
		Lottos lottos = Lottos.purchase(PurchaseInput.of("10000"));
		String result = LottoReport.reportLottos(lottos);

		assertThat(result).contains(String.format(Message.MSG_PURCHASE_LOTTO_CNT, 10));
	}

	@DisplayName("reportLottoResult 당첨 통계 문자열을 얻을 수 있고, 3개 이상 매칭된 결과 리포트 값이 포함된다.")
	@ParameterizedTest
	@MethodSource("argReportLottoResult")
	void reportLottoResult(WinNumbers input) {
		List<Lotto> lottos = Arrays.asList(
			Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
			Lotto.of(Arrays.asList(11, 12, 13, 14, 15, 16)),
			Lotto.of(Arrays.asList(21, 22, 23, 24, 25, 26))
		);
		LottoResult lottoResult = LottoResult.analyze(input, lottos);
		Map<LottoResultType, Integer> results = lottoResult.getResults();

		String result = LottoReport.reportLottoResult(lottoResult);

		for (LottoResultType resultType : LottoResultType.getReportTargets()) {
			assertThat(result).contains(String.format(Message.MSG_WIN_STATISTICS
				, resultType.getMatchCount()
				, resultType.getReward()
				, results.get(resultType)));
		}
	}

	public static Stream<Arguments> argReportLottoResult() {
		return Stream.of(
			Arguments.of(WinNumbers.of("1,2,3,43,44,45")),
			Arguments.of(WinNumbers.of("1,2,11,12,13,14")),
			Arguments.of(WinNumbers.of("21,22,23,24,25,31")),
			Arguments.of(WinNumbers.of("1,2,3,4,5,6"))
		);
	}
}