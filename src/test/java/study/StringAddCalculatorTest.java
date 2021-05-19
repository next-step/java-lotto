package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

	@ParameterizedTest
	@NullAndEmptySource
	public void splitAndSum_null_또는_빈문자(String input) {
		assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() {
		assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() {
		assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() {
		assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자() {
		assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

}
