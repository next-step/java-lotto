package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	@DisplayName(value = "null 혹은 empty string 을 전달하면 0을 반환한다")
	void emptyString() {
		int empty = StringCalculator.sumByDelimiter("");
		int inputNull = StringCalculator.sumByDelimiter(null);
		assertThat(empty).isEqualTo(0);
		assertThat(inputNull).isEqualTo(0);
	}

}
