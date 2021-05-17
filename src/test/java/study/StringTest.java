package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1", "2");
	}

	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인")
	@Test
	void substring() {
		String input = "(1,2)";
		assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
	}

	@DisplayName("\"abc\" 를 String의 charAt() 메소드를 통해 특정 위치의 문자를 가져오는지 확인")
	@Test
	void charAtTest() {
		String input = "abc";
		char[] charArray = input.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			assertThat(input.charAt(i)).isEqualTo(charArray[i]);
		}
	}

	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 테스트.")
	@Test
	void isCharAtThrowException() {
		String input = "abc";
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> input.charAt(input.length()))
			.withMessageMatching("String index out of range: \\d+");
	}
}
