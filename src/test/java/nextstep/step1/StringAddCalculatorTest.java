package nextstep.step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
	private StringSumCalculator underTest = new StringSumCalculator();

	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = underTest.sum(null);
		assertThat(result).isEqualTo(0);

		result = underTest.sum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() {
		int result = underTest.sum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() {
		int result = underTest.sum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() {
		int result = underTest.sum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자() {
		int result = underTest.sum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> underTest.sum("-1,2,3"))
				.isInstanceOf(RuntimeException.class);
	}
}
