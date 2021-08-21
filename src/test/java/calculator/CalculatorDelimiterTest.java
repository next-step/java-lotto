package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorDelimiterTest {

	@Test
	@DisplayName("구분자를 통해서 숫자들을 추출한다.")
	void delimiter() {
		CalculatorDelimiter delimiter = new CalculatorDelimiter(",|:");
		assertThat(delimiter.operate("1,2:3")).containsExactly("1", "2", "3");
	}
}
