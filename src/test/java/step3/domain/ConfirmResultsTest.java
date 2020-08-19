package step3.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.constants.PrizeGrade;
import step3.constants.RateOfReturn;
import step3.domain.ConfirmResults;
import step3.domain.PurchaseStandBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.constants.MessageConstant.RATE_OF_RETURN_FORMAT;
import static step3.constants.PrizeGrade.THIRD;

class ConfirmResultsTest {

	@DisplayName("수익률 확인 메소드 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingComputeRateOfReturn")
	void computeRateOfReturn(List<PrizeGrade> given, PurchaseStandBy request, String result) {
		assertThat(new ConfirmResults(given).computeRateOfReturn(request)).isEqualTo(result);
	}

	@DisplayName("게임 결과 받는 돈 테스트")
	@ParameterizedTest
	@MethodSource("provideTestingGetPrizeRewardSum")
	void getPrizeRewardSum(List<PrizeGrade> given, long result) {
		assertThat(new ConfirmResults(given).getPrizeRewardSum()).isEqualTo(result);
	}

	static Stream<Arguments> provideTestingComputeRateOfReturn() {
		List<PrizeGrade> confirmResults = Arrays.stream(PrizeGrade.values())
				.filter(prizeGrade -> prizeGrade == THIRD)
				.collect(Collectors.toList());
		PurchaseStandBy purchaseStandBy = new PurchaseStandBy(14_000);
		double rateOfReturn = (double) THIRD.getReward() / (double) purchaseStandBy.getPurchasePrice();

		return Stream.of(
				Arguments.of(confirmResults, purchaseStandBy, String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage()))
		);
	}

	static Stream<Arguments> provideTestingGetPrizeRewardSum() {
		List<PrizeGrade> confirmResults = Arrays.stream(PrizeGrade.values())
														.filter(prizeGrade -> prizeGrade == THIRD)
														.collect(Collectors.toList());


		return Stream.of(
				Arguments.of(confirmResults, 50000L)
		);
	}
}
