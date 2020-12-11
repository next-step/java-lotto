package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

	@DisplayName("anlalyze메서드를 통해 WinNumberInput값을 받아 매칭결과를 확인할 수 있다.")
	@ParameterizedTest
	@MethodSource("argMatchResult")
	void matchResult(WinNumbers input, Map<LottoResultType, Integer> expected) {

		List<Lotto> lottos = Arrays.asList(
			Lotto.of(Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6))),
			Lotto.of(Arrays.asList(LottoNo.of(11), LottoNo.of(12), LottoNo.of(13), LottoNo.of(14), LottoNo.of(15), LottoNo.of(16))),
			Lotto.of(Arrays.asList(LottoNo.of(21), LottoNo.of(22), LottoNo.of(23), LottoNo.of(24), LottoNo.of(25), LottoNo.of(26)))
		);
		LottoResult lottoResult = LottoResult.analyze(input, lottos);
		Map<LottoResultType, Integer> result = lottoResult.getResults();

		assertThat(result).isEqualTo(expected);
	}

	public static Stream<Arguments> argMatchResult() {
		Map<LottoResultType, Integer> result1 = new HashMap<>();
		result1.put(LottoResultType.ZERO_MATCH, 2);
		result1.put(LottoResultType.ONE_MATCH, 0);
		result1.put(LottoResultType.TWO_MATCH, 0);
		result1.put(LottoResultType.THREE_MATCH, 1);
		result1.put(LottoResultType.FOUR_MATCH, 0);
		result1.put(LottoResultType.FIVE_MATCH, 0);
		result1.put(LottoResultType.FIVE_MATCH_AND_BONUS, 0);
		result1.put(LottoResultType.SIX_MATCH, 0);

		Map<LottoResultType, Integer> result2 = new HashMap<>();
		result2.put(LottoResultType.ZERO_MATCH, 1);
		result2.put(LottoResultType.ONE_MATCH, 0);
		result2.put(LottoResultType.TWO_MATCH, 1);
		result2.put(LottoResultType.THREE_MATCH, 0);
		result2.put(LottoResultType.FOUR_MATCH, 1);
		result2.put(LottoResultType.FIVE_MATCH, 0);
		result2.put(LottoResultType.FIVE_MATCH_AND_BONUS, 0);
		result2.put(LottoResultType.SIX_MATCH, 0);

		Map<LottoResultType, Integer> result3 = new HashMap<>();
		result3.put(LottoResultType.ZERO_MATCH, 2);
		result3.put(LottoResultType.ONE_MATCH, 0);
		result3.put(LottoResultType.TWO_MATCH, 0);
		result3.put(LottoResultType.THREE_MATCH, 0);
		result3.put(LottoResultType.FOUR_MATCH, 0);
		result3.put(LottoResultType.FIVE_MATCH, 1);
		result3.put(LottoResultType.FIVE_MATCH_AND_BONUS, 0);
		result3.put(LottoResultType.SIX_MATCH, 0);

		Map<LottoResultType, Integer> result4 = new HashMap<>();
		result4.put(LottoResultType.ZERO_MATCH, 2);
		result4.put(LottoResultType.ONE_MATCH, 0);
		result4.put(LottoResultType.TWO_MATCH, 0);
		result4.put(LottoResultType.THREE_MATCH, 0);
		result4.put(LottoResultType.FOUR_MATCH, 0);
		result4.put(LottoResultType.FIVE_MATCH, 0);
		result4.put(LottoResultType.FIVE_MATCH_AND_BONUS, 1);
		result4.put(LottoResultType.SIX_MATCH, 0);

		Map<LottoResultType, Integer> result5 = new HashMap<>();
		result5.put(LottoResultType.ZERO_MATCH, 2);
		result5.put(LottoResultType.ONE_MATCH, 0);
		result5.put(LottoResultType.TWO_MATCH, 0);
		result5.put(LottoResultType.THREE_MATCH, 0);
		result5.put(LottoResultType.FOUR_MATCH, 0);
		result5.put(LottoResultType.FIVE_MATCH, 0);
		result5.put(LottoResultType.FIVE_MATCH_AND_BONUS, 0);
		result5.put(LottoResultType.SIX_MATCH, 1);

		return Stream.of(
			Arguments.of(WinNumbers.of("1,2,3,43,44,45", "10"), result1),
			Arguments.of(WinNumbers.of("1,2,11,12,13,14", "7"), result2),
			Arguments.of(WinNumbers.of("21,22,23,24,25,31", "1"), result3),
			Arguments.of(WinNumbers.of("21,22,23,24,25,31", "26"), result4),
			Arguments.of(WinNumbers.of("1,2,3,4,5,6", "45"), result5)
		);
	}
}