package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@DisplayName("덧셈")
	@Test
	void test1() {
		StringCalculator stringCalculator = new StringCalculator("1", "2");
		Number result = stringCalculator.add();
		assertThat(result).isEqualTo(new Number(3));
	}
}
