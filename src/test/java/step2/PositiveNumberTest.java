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
}
