package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	@DisplayName(value = "1,2가 정상적으로 분리된다.")
	public void splitString() throws Exception {
		String str = "1,2";
		String[] result = str.split(",");
		assertThat(result).hasSize(2);
		assertThat(result).contains("1");
		assertThat(result).contains("2");
	}

	@Test
	@DisplayName(value = "1만 포함하는 배열로 반환된다.")
	public void splitSingleString() throws Exception {
		String str = "1,";
		String[] result = str.split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName(value = "1,2 문자열이 반환 된다.")
	public void removeParenthesesUsingSubstring() throws Exception {
		String str = "(1,2)";
		String result = str.substring(1, str.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}
}
