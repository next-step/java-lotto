package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositiveNumberTest {
	@Test
	public void valueOf_양수() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void valueOf_실패_음수() throws Exception {
		assertThatThrownBy(() -> PositiveNumber.valueOf("-123"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void valueOf_실패_문자열() throws Exception {
		assertThatThrownBy(() -> PositiveNumber.valueOf("ㄱ"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void sum_성공() throws Exception {
		PositiveNumber number1 = PositiveNumber.valueOf("21");
		PositiveNumber number2 = PositiveNumber.valueOf("33");

		PositiveNumber result = PositiveNumber.sum(number1, number2);
		assertThat(result).isEqualTo(PositiveNumber.valueOf("54"));
	}

	@Test
	public void sum_실패_null입력() throws Exception {
		PositiveNumber number = PositiveNumber.valueOf("10");
		assertThatThrownBy(() -> PositiveNumber.sum(number, null))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> PositiveNumber.sum(null, number))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> PositiveNumber.sum(null, null))
			.isInstanceOf(RuntimeException.class);

	}
}
