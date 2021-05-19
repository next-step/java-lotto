package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RateTest {

	@ParameterizedTest
	@DisplayName("특정 자리까지 소수점을 버릴수 있다")
	@CsvSource(value = {"1.314:1:1.3", "0.424:6:0.424000", "0.1234:0:0"}, delimiter = ':')
	public void floorTest(double rate, int floorPos, double expectedFloorRate) {
		Rate originRate = Rate.of(rate);

		Rate floorRate = originRate.floor(floorPos);

		assertThat(floorRate).isEqualTo(Rate.of(expectedFloorRate));
	}

	@ParameterizedTest
	@DisplayName("double 형 데이터와 크기 비교를 할 수 있다.")
	@CsvSource(value = {"1.0:true", "0.5:true", "1.1:false"}, delimiter = ':')
	public void greaterThanTest(double other, boolean expected) {
		Rate rate = Rate.of(1.0);

		assertThat(rate.equalOrGreaterThan(other)).isEqualTo(expected);
	}

}
