package study.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	public void splitAndSum_null_or_empty() throws Exception {
		//given

		//when
		int result = StringAddCalculator.splitAndSum(null);

		//then
		assertThat(result).isEqualTo(0);

		//given

		//when
		result = StringAddCalculator.splitAndSum("");

		//then
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_one_number() throws Exception {
		//given

		//when
		int result = StringAddCalculator.splitAndSum("1");

		//then
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_comma_delimiter() throws Exception {
		//given

		//when
		int result = StringAddCalculator.splitAndSum("1,2");

		//then
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_colon_comma_delimiter() throws Exception {
		//given

		//when
		int result = StringAddCalculator.splitAndSum("1,2:3");

		//then
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_delimiter() throws Exception {
		//given

		//when
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

		//then
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_delimiter_with_null() throws Exception {
		//given

		//when
		int result = StringAddCalculator.splitAndSum("//;\n1;;2;,:3");

		//then
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() throws Exception {
		//given

		//when

		//then - throw Exception
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
