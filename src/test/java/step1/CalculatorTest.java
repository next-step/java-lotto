package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

	@DisplayName(value = "문자열 목록의 총 합을 구하는 기능")
	@Test
	void getIntegerSumOfStrings() {
		String[] strings = new String[] {"5","7","3","4"};
		int result = Calculator.getIntegerSumOfStrings(strings);
		assertThat(result).isEqualTo(19);
	}

}
