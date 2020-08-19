package step2.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.LottoException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateOfReturnTest {

	@DisplayName("수익률 enum이 제대로 반환 되는지 테스트")
	@ParameterizedTest
	@MethodSource("provide")
	void mappingTest(double number, RateOfReturn rateOfReturn) {
		assertThat(RateOfReturn.of(number)).isEqualTo(rateOfReturn);
	}

	@DisplayName("수익률이 음수로 들어오면 LottoException 발생")
	@Test
	void mappingExceptionTest() {
		double given = -1D;
		assertThrows(LottoException.class, () -> RateOfReturn.of(given));
	}

	static Stream<Arguments> provide() {
		return Stream.of(
				Arguments.of(0D, RateOfReturn.LOSS),
				Arguments.of(1D, RateOfReturn.SAME),
				Arguments.of(2D, RateOfReturn.GAIN)
		);
	}
}
