package step1.util;

import org.junit.jupiter.api.Test;
import step1.domain.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilTest {
	
	@Test
	public void isEmptyTest() {
		assertThat(StringUtil.isEmpty("")).isTrue();
		assertThat(StringUtil.isEmpty("dd")).isFalse();
	}
	
	@Test
	public void splitTest() {
		String[] test2 = {"1", "2", "3"};
		assertThat(StringUtil.splitWithDelemeter("//;\n1;2;3", ",")).isEqualTo(test2);
	}

	@Test
	public void splitTest2() {
		String[] test =  {"1","2","3"};
		assertThat(StringUtil.splitWithDelemeter("1,2,3", ",")).isEqualTo(test);
	}

	@Test
	public void stringValueTest() throws Exception {
		String notNumeric = "a";
		assertThatThrownBy(() ->StringUtil.StringToInt(notNumeric))
				.isInstanceOf(RuntimeException.class);
	}
}
