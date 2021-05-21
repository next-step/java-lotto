package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

	@Test
	void mathRoundTest() {
		assertThat(NumberUtils.mathRound(100, 100, DecimalType.PLACE_TWO))
			.isEqualTo(1.0);

		assertThat(NumberUtils.mathRound(30, 100, DecimalType.PLACE_TWO))
			.isEqualTo(0.3);

		assertThat(NumberUtils.mathRound(10, 15, DecimalType.PLACE_TWO))
			.isEqualTo(0.67);
	}
}
