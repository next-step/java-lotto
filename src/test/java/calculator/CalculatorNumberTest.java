package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorNumberTest {

	@Test
	@DisplayName("더하기")
	void plus() {
		CalculatorNumber n1 = new CalculatorNumber(1);
		CalculatorNumber n2 = new CalculatorNumber(2);

		assertThat(n1.add(n2)).isEqualTo(new CalculatorNumber(3));
	}

	@Test
	@DisplayName("음수")
	void negativeNumber() {
		assertThatThrownBy(() -> {
			CalculatorNumber n = new CalculatorNumber(-1);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자이외의 값")
	void normalString() {
		assertThatThrownBy(() -> {
			CalculatorNumber n = new CalculatorNumber("H");
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
