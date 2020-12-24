package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.ReturnRate;

public class ReturnRateTest {
	@DisplayName("수익률이 제대로 계산되는지 확인한다.")
	@ParameterizedTest
	@MethodSource("provideLottoResultsAndMoney")
	void calculateTest(int money, List<LottoResult> source, double expected) {
		LottoResults lottoResults = LottoResults.of(source);

		ReturnRate returnRate = ReturnRate.calculate(money, lottoResults);
		assertThat(returnRate).isEqualTo(ReturnRate.of(expected));
	}

	private static Stream<Arguments> provideLottoResultsAndMoney() {
		return Stream.of(
			Arguments.of(2_000, Collections.singletonList(LottoResult.FIRST),
				1_000_000),
			Arguments.of(500_500, Arrays.asList(LottoResult.THIRD, LottoResult.FOURTH),
				0.11),
			Arguments.of(15_000, Collections.singletonList(LottoResult.FOURTH),
				0.33)
		);
	}
}
