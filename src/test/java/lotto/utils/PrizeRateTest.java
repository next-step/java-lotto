package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeRateTest {

	@ParameterizedTest
	@DisplayName("A와 B를 나눈 퍼센트 값이 반환된다.(퍼센트 기준은 1)")
	@CsvSource(value = {"5000,14000,0.36", "14000,14000,1", "28000,14000,2"})
	public void returnPercent(int value1, int value2, String percent) {
		String result = PrizeRate.getPrizeEarningRate(value1, value2);

		assertThat(result).isEqualTo(percent);
	}
}