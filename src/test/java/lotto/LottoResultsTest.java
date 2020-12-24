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

public class LottoResultsTest {
	@DisplayName("상금 총액이 제대로 계산되는지 확인한다.")
	@ParameterizedTest
	@MethodSource("provideLottoResults")
	void sumResultMoneyTest(List<LottoResult> source, int moneyAmount) {
		LottoResults lottoResults = LottoResults.of(source);

		assertThat(lottoResults.sumResultMoney())
			.isEqualTo(Money.of(moneyAmount));
	}

	private static Stream<Arguments> provideLottoResults() {
		return Stream.of(
			Arguments.of(Arrays.asList(LottoResult.FIRST, LottoResult.NONE, LottoResult.THIRD),
				2_000_000_000 + 50_000),
			Arguments.of(Collections.singletonList(LottoResult.FIRST),
				2_000_000_000)
		);
	}
}
