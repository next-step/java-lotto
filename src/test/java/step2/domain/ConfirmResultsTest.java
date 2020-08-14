package step2.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.constants.PrizeGrade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.constants.MessageConstant.PRIZE_STATISTICS_FORMAT;
import static step2.constants.PrizeGrade.THIRD;

class ConfirmResultsTest {

	@DisplayName("게임 결과 확인 메소드 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingGetStatistics")
	void getStatistics(List<ConfirmResult> given, String result) {
		assertThat(new ConfirmResults(given).getStatistics()).isEqualTo(result);
	}

	@DisplayName("게임 결과 받는 돈 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingGetPrizeRewardSum")
	void getPrizeRewardSum(List<ConfirmResult> given, int result) {
		assertThat(new ConfirmResults(given).getPrizeRewardSum()).isEqualTo(result);
	}

	static Stream<Arguments> provideTestingGetStatistics() {
		List<ConfirmResult> confirmResults = Arrays.stream(PrizeGrade.values())
				.map(ConfirmResult::new)
				.filter(confirmResult -> confirmResult.getPrizeGrade() == THIRD)
				.collect(Collectors.toList());


		return Stream.of(
				Arguments.of(confirmResults,String.format(PRIZE_STATISTICS_FORMAT, THIRD.getMatchCount(), THIRD.getReward(), 1))
		);
	}

	static Stream<Arguments> provideTestingGetPrizeRewardSum() {
		List<ConfirmResult> confirmResults = Arrays.stream(PrizeGrade.values())
														.map(ConfirmResult::new)
														.filter(confirmResult -> confirmResult.getPrizeGrade() == THIRD)
														.collect(Collectors.toList());


		return Stream.of(
				Arguments.of(confirmResults, 50000)
		);
	}
}