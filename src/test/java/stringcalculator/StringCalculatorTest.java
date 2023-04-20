package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@DisplayName("덧셈")
	@Test
	void test1() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(1, 2);
		assertThat(result).isEqualTo(3);
	}
}
