package lotto;

import lotto.domain.ResultReport;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultReportTest {

	@DisplayName("단일 당첨 케이스 상금 확인")
	@ParameterizedTest
	@MethodSource("provideSingleResult")
	void verifyReward(LottoResult result, int expectReward) {

		ResultReport report = new ResultReport();
		report.increment(result);

		int totalReward = report.totalReward();

		assertThat(totalReward).isEqualTo(expectReward);
	}

	private static Stream<Arguments> provideSingleResult(){
		return Stream.of(
				Arguments.of(LottoResult.WIN_1ST, 2000000000),
				Arguments.of(LottoResult.WIN_3RD, 1500000),
				Arguments.of(LottoResult.WIN_4TH, 50000),
				Arguments.of(LottoResult.WIN_5TH, 5000),
				Arguments.of(LottoResult.FAIL, 0)
		);
	}

	@DisplayName("다중, 복합 당첨 케이스 상금 확인")
	@ParameterizedTest
	@MethodSource("provideComplexResult")
	void verifyRewardComplex(List<LottoResult> results, int expectReward) {
		ResultReport report = new ResultReport();

		for(LottoResult result : results){
			report.increment(result);
		}

		int totalReward = report.totalReward();

		assertThat(totalReward).isEqualTo(expectReward);
	}

	private static Stream<Arguments> provideComplexResult(){
		return Stream.of(
				Arguments.of(Arrays.asList(LottoResult.WIN_1ST, LottoResult.WIN_3RD), 2001500000),
				Arguments.of(Arrays.asList(LottoResult.WIN_3RD, LottoResult.WIN_5TH), 1505000),
				Arguments.of(Arrays.asList(LottoResult.WIN_4TH, LottoResult.WIN_4TH, LottoResult.WIN_5TH, LottoResult.FAIL), 105000)
		);
	}

}