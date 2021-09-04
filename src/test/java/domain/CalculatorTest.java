package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = calculator.calculate(null);
		assertThat(result).isEqualTo(0);

		result = calculator.calculate("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = calculator.calculate("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = calculator.calculate("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = calculator.calculate("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = calculator.calculate("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
						.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void splitAndSum_other_charter() throws Exception {
		assertThatThrownBy(() -> calculator.calculate("1,2,3a"))
						.isInstanceOf(RuntimeException.class);
	}
}
